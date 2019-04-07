package com.whcm.report.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 小程序用户表 report_wx_user
 * 
 * @author dong.chao
 * @date 2019-04-07
 */

@Data
public class WxUser extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer wxUserId;
	/** 小程序用户的openid */
	private String wxUserOpenid;
	/** 用户头像 */
	private String wxUserNickname;
	/** 用户头像 */
	private String wxUserAvatarurl;
	/** 性别  0-男、1-女 */
	private Integer wxUserGender;
	/** 所在国家 */
	private String wxUserCountry;
	/** 省份 */
	private String wxUserProvince;
	/** 城市 */
	private String wxUserCity;
	/** 语种 */
	private String wxUserLanguage;
	/** 创建/注册时间 */
	private Date wxUserCtime;
	/** 手机号码 */
	private String mobile;



}
