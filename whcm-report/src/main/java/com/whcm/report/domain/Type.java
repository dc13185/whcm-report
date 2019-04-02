package com.whcm.report.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 节目类型表 report_type
 * 
 * @author dong.chao
 * @date 2019-04-02
 */

@Data
public class Type extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 分类id */
	private Integer typeId;
	/**  */
	private String typeName;


    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("typeId", getTypeId())
            .append("typeName", getTypeName())
            .toString();
    }
}
