package com.whcm.report.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 留言表 report_message
 * 
 * @author dong.chao
 * @date 2019-04-09
 */
public class Message extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
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

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("messageId", getMessageId())
            .append("wxUserOpenid", getWxUserOpenid())
            .append("nickname", getNickname())
            .append("massage", getMassage())
            .append("avatarUrl", getAvatarUrl())
            .toString();
    }
}
