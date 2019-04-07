package com.whcm.report.controller.wx;



import com.alibaba.fastjson.JSON;
import com.ruoyi.common.utils.aescbc.AesCbcUtil;
import com.ruoyi.common.utils.http.HttpUtils;
import com.whcm.report.domain.WxUser;
import com.whcm.report.service.IWxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: dong.chao
 * @create: 2019-04-07 13:44
 * @description: 微信小程序对应接口
 **/

@RestController
@RequestMapping("/wx/user")
public class WxUserController {

    @Autowired
    private IWxUserService userService;

    /** 小程序ID */
    private static String wxspAppid = "wx3e6bae0e844e3d41";

    private static String wxspSecret = "aba72a47d82f01fb40157f19aee715fe";


    @RequestMapping("/login")
    public Map decodeUserInfo(String encryptedData, String iv, String code) {
        Map map = new HashMap();
        //登录凭证不能为空
        if (code == null || code.length() == 0) {
            map.put("status", 0);
            map.put("msg", "code 不能为空");
            return map;
        }

        //授权（必填）
        String grantType = "authorization_code";

        //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid ////////////////
        //请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grantType;
        //发送请求
        String sr = HttpUtils.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        //解析相应内容（转换成json对象）
        Map json = (Map)JSON.parse(sr);
        //获取会话密钥（session_key）
        String session_key = json.get("session_key").toString();
        //用户的唯一标识（openid）
        String openid = (String) json.get("openid");

        //////////////// 2、对encryptedData加密数据进行AES解密 ////////////////
        try {
            String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
            if (null != result && result.length() > 0) {
                map.put("status", 1);
                map.put("msg", "解密成功");

                Map userInfoJSON = (Map)JSON.parse(result);
                Map userInfo = new HashMap(8);

                String openId =  (String)userInfoJSON.get("openId");
                String nickName =  (String)userInfoJSON.get("nickName");
                String gender =  (String)userInfoJSON.get("gender");
                String city =  (String)userInfoJSON.get("city");
                String province =  (String)userInfoJSON.get("province");
                String country =  (String)userInfoJSON.get("country");
                String avatarUrl = (String)userInfoJSON.get("avatarUrl");
                String unionId =  (String)userInfoJSON.get("unionId");

                //入库
                WxUser wxUser = new WxUser();
                wxUser.setWxUserOpenid(openId);
                wxUser.setWxUserNickname(nickName);
                wxUser.setWxUserGender(Integer.parseInt(gender));
                wxUser.setWxUserCity(city);
                wxUser.setWxUserProvince(province);
                wxUser.setWxUserCountry(country);
                wxUser.setWxUserAvatarurl(avatarUrl);
                wxUser.setUpdateTime(new Date());
                userService.insertWxUser(wxUser);

                userInfo.put("openId", openId);
                userInfo.put("nickName",nickName);
                userInfo.put("gender",gender);
                userInfo.put("city", city);
                userInfo.put("province",province);
                userInfo.put("country", country);
                userInfo.put("avatarUrl", avatarUrl);
                userInfo.put("unionId", userInfoJSON.get("unionId"));
                map.put("userInfo", userInfo);

                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("status", 0);
        map.put("msg", "解密失败");
        return map;
    }


}
