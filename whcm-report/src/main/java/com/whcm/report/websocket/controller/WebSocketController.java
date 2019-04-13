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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: dong.chao
 * @create: 2019-04-09 08:25
 * @description: WebSocketDemo
 **/

@Slf4j
@RequestMapping("/wx/webSocket")
@RestController
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
    @RequestMapping(value = "/sendMassage")
    public Map send( String wxOpenId,  String avatarUrl,  String nickname, String msg){
        Map result = new HashMap(3);
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
                result.put("status","success");

            }catch (Exception e){
                log.error(e.getMessage());
                result.put("error",e.getMessage());
            }
        }

        return  result;
    }




    @RequestMapping(value = "/getMassage")
    public Map getMassage(Integer count){
        Integer size = 20;
        Integer pageCount = count * size;
        Map result = new HashMap(3);
        try {
            List<Message> messageList = messageService.selectMessageListByPage(pageCount);
            result.put("status","1");
            result.put("msg",messageList);
        }catch (Exception e){
            e.printStackTrace();
            result.put("status","0");
            result.put("msg",e.getMessage());
        }

        return result;
    }
}
