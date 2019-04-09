package com.whcm.report.websocket.domain;

import lombok.Data;

/**
 * @author: dong.chao
 * @create: 2019-04-09 23:37
 * @description: WebSocket传输Modal
 **/

@Data
public class MassageModal {

    private String wxOpenId;

    /** 头像 */
    private String avatarUrl;

    /** 昵称 */
    private String nickname;

    /** 消息 */
    private String massage;

}
