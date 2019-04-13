package com.whcm.report.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 节目表 report_program
 * 
 * @author dong.chao
 * @date 2019-04-02
 */

@Data
public class Program {
	private static final long serialVersionUID = 1L;

	/** 节目Id
 */
	private Integer programId;
	/** 节目名称 */
	private String programName;
	/** 节目图片URL */
	private String programPictureurl;

	/** 封面图片 */
	private String coverUrl;

	/** 类型Id */
	private Integer typeId;
	/** 节目内容*/
	private String programContent;
	/** 所属学院 */
	private String typeName;
    /** 人员 */
	private String personnel;
	/** 后缀 */
	private String suffix;

	private int votes;

	private int comments;

	private int isVote;


	private String wxUserOpenId;

	private String comment = "/images/ico/comment.png";

	private boolean comment_switch = false;

	private String fabulous = "/images/ico/Fabulous.png";



}
