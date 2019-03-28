package com.whcm.report.service;

import com.whcm.report.domain.Banner;
import java.util.List;

/**
 * 轮播图 服务层
 * 
 * @author dong.chao
 * @date 2019-03-28
 */
public interface IBannerService 
{
	/**
     * 查询轮播图信息
     * 
     * @param bannerId 轮播图ID
     * @return 轮播图信息
     */
	public Banner selectBannerById(Integer bannerId);
	
	/**
     * 查询轮播图列表
     * 
     * @param banner 轮播图信息
     * @return 轮播图集合
     */
	public List<Banner> selectBannerList(Banner banner);
	
	/**
     * 新增轮播图
     * 
     * @param banner 轮播图信息
     * @return 结果
     */
	public int insertBanner(Banner banner);
	
	/**
     * 修改轮播图
     * 
     * @param banner 轮播图信息
     * @return 结果
     */
	public int updateBanner(Banner banner);
		
	/**
     * 删除轮播图信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBannerByIds(String ids);
	
}
