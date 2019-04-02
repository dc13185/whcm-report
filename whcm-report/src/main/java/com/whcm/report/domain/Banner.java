package com.whcm.report.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 轮播图表 report_banner
 * 
 * @author dong.chao
 * @date 2019-03-28
 */

@Data
public class Banner extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer bannerId;
	/**  */
	private String bannerUrl;


    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("bannerId", getBannerId())
            .append("bannerUrl", getBannerUrl())
            .toString();
    }
}
