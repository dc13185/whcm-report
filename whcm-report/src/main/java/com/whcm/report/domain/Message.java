package com.whcm.report.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 留言表 report_message
 * 
 * @author dong.chao
 * @date 2019-04-09
 */
public class Message
{
	/**  */
	private Integer messageId;
	/**  */
	private String wxUserOpenid;
	/**  */
	private String nickname;
	/**  */
	private String massage;
	/**  */
	private String avatarUrl;

	private Date sendTime;

	public void setMessageId(Integer messageId) 
	{
		this.messageId = messageId;
	}

	public Integer getMessageId() 
	{
		return messageId;
	}
	public void setWxUserOpenid(String wxUserOpenid) 
	{
		this.wxUserOpenid = wxUserOpenid;
	}

	public String getWxUserOpenid() 
	{
		return wxUserOpenid;
	}
	public void setNickname(String nickname) 
	{
		this.nickname = nickname;
	}

	public String getNickname() 
	{
		return nickname;
	}
	public void setMassage(String massage) 
	{
		this.massage = massage;
	}

	public String getMassage() 
	{
		return massage;
	}
	public void setAvatarUrl(String avatarUrl) 
	{
		this.avatarUrl = avatarUrl;
	}

	public String getAvatarUrl() 
	{
		return avatarUrl;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
}
