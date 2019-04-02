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
public class Program extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** 节目Id
 */
	private Integer programId;
	/** 节目名称 */
	private String programName;
	/** 节目图片URL */
	private String programPictureurl;
	/** 类型Id */
	private Integer typeId;
	/** 节目内容*/
	private String programContent;
	/** 所属学院 */
	private String typeName;


    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("programId", getProgramId())
            .append("programName", getProgramName())
            .append("programPictureurl", getProgramPictureurl())
            .append("typeId", getTypeId())
            .append("programContent", getProgramContent())
            .toString();
    }
}
