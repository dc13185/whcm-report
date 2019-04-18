package com.whcm.report.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 反馈表 report_feedback
 * 
 * @author dong.chao
 * @date 2019-04-18
 */

@Data
public class Feedback
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer feedbackId;
	/**  */
	private String feedbackMain;

}
