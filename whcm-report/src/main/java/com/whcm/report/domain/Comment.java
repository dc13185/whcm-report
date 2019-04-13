package com.whcm.report.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 节目评论表 report_comment
 * 
 * @author dong.chao
 * @date 2019-04-07
 */
@Data
public class Comment
{
	private static final long serialVersionUID = 1L;
	
	/** 评论Id */
	private Integer commentId;
	/** 评论内容 */
	private String commentMain;
	/** 评论用户 */
	private String xwUserOpenid;
	/** 节目Id */
	private Integer programId;

	private String  nickname;

	private String  avatarurl;

}
