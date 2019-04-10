package com.whcm.report.websocket.controller;

import com.alibaba.fastjson.JSONObject;
import com.whcm.report.domain.Message;
import com.whcm.report.service.IMessageService;
import com.whcm.report.websocket.server.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: dong.chao
 * @create: 2019-04-09 08:25
 * @description: WebSocketDemo
 **/

@Slf4j
@RequestMapping("/wx/webSocket")
@Controller
public class WebSocketController {

    @Autowired
    private IMessageService messageService;


    /**
     * 跳转登录页
     * @return
     */
    @RequestMapping("/show")
    public String show(){
        return "report/show";
    }

    /**
     * 跳转聊天页面
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/login/{wxOpenId}", method = RequestMethod.GET)
    public String login(@PathVariable("wxOpenId") int id, HttpServletRequest request){
        request.getSession().setAttribute("id", id);
        return "report/main";
    }

    /**
     * 发送消息
     * @param
     * @param
     * @return
     */
    @PostMapping(value = "/sendMassage")
    @ResponseBody
    public String send(String wxOpenId,String avatarUrl,String nickname,String msg){
        synchronized (wxOpenId.intern()){
            try{
                //入库
                Message message = new Message();
                message.setAvatarUrl(avatarUrl);
                message.setNickname(nickname);
                message.setMassage(msg);
                message.setWxUserOpenid(wxOpenId);

                messageService.insertMessage(message);
                //发送消息
                String sendMassage = JSONObject.toJSONString(message);
                // sid 为null 推送所有人  sid不为null时  推送给指定的 id
                 WebSocketServer.sendInfo(sendMassage);
                return "success";
            }catch (Exception e){
                log.error(e.getMessage());
                return "report/faile";
            }
        }
    }
}
