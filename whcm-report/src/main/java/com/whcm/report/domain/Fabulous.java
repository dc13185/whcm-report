package com.whcm.report.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 点赞表 report_fabulous
 * 
 * @author dong.chao
 * @date 2019-04-08
 */
@Data
public class Fabulous
{
	private static final long serialVersionUID = 1L;
	
	/** 点赞主键 */
	private Integer fabulousId;
	/** userOpenid */
	private String xwUserOpenid;
	/**  */
	private Integer programId;

}
