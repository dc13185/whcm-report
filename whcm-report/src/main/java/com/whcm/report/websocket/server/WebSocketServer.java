package com.whcm.report.websocket.server;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.common.utils.spring.SpringUtils;
import com.whcm.report.service.IVoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author: dong.chao
 * @create: 2019-04-08 16:17
 * @description: WebSocket
 **/

@Slf4j
@Component
@ServerEndpoint("/wx/websocket/link/{typeId}")
public class WebSocketServer {

        private IVoteService voteService = SpringUtils.getBean(IVoteService.class);


        /** 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。*/
        private static int onlineCount = 0;
        /** concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。*/
        private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();

        /** 与某个客户端的连接会话，需要通过它来给客户端发送数据*/
        private Session session;

        /** 接收sid */
        /**
         * 连接建立成功调用的方法*/
        @OnOpen
        public void onOpen(Session session, @PathParam("typeId") String typeId) {
            this.session = session;
            //加入set中
            webSocketSet.add(this);
            //在线数加1
            //addOnlineCount();
            String counts = voteService.selectVoteCount(Integer.parseInt(typeId));
            WebSocketServer.onlineCount = Integer.parseInt(counts);
            //票数详情
            List<Object> votes = voteService.selectAllVotes();
            String votesMassage = JSONObject.toJSONString(votes);
            try {
                Map<String,Object> map= new HashMap(2);
                map.put("votes",votesMassage);
                map.put("count",WebSocketServer.onlineCount);
                // 定义JackJson 对象
                ObjectMapper mapper = new ObjectMapper();
                //将map转换成JSON字符串
                String image_json = mapper.writeValueAsString(map);

                for (WebSocketServer item : webSocketSet) {
                    item.sendMessage(image_json);
                }
            } catch (IOException e) {
                e.printStackTrace();
                log.error("websocket IO异常");
            }
         }

        /**
         * 连接关闭调用的方法
         */
        @OnClose
        public void onClose() {
            //从set中删除
            webSocketSet.remove(this);
            //在线数减1
             //subOnlineCount();
            log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
         }

        /**
         * 收到客户端消息后调用的方法
         *
         * @param message 客户端发送过来的消息*/
        @OnMessage
        public void onMessage(String message, Session session) {
        //群发消息
        for (WebSocketServer item : webSocketSet) {
                try {
                    item.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         *
         * @param session
         * @param error
         */
        @OnError
        public void onError(Session session, Throwable error) {
            log.error("发生错误");
            error.printStackTrace();
        }
        /**
         * 实现服务器主动推送
         */
        public void sendMessage(String message) throws IOException {
            this.session.getBasicRemote().sendText(message);
        }


        /**
         * 群发自定义消息
         * */
        public static void sendInfo(String message)  {
            try {
                Map<String,Object> map= new HashMap(2);
                map.put("votes",message);
                map.put("count",++WebSocketServer.onlineCount);
                // 定义JackJson 对象
                ObjectMapper mapper = new ObjectMapper();
                //将map转换成JSON字符串
                String image_json = mapper.writeValueAsString(map);
                for (WebSocketServer item : webSocketSet) {
                    item.sendMessage(image_json);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

         }

        public static synchronized int getOnlineCount() {  return onlineCount;}

        public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

        public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

}
