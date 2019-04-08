package com.whcm.report.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 投票表 report_vote
 * 
 * @author dong.chao
 * @date 2019-04-08
 */

@Data
public class Vote
{
	private static final long serialVersionUID = 1L;
	
	/** 投票id */
	private Integer voteId;
	/** 节目Id */
	private Integer programId;
	/** 用户id */
	private String xwUserOpenid;


}
