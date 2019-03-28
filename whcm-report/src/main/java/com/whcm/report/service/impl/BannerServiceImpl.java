package com.whcm.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.whcm.report.mapper.BannerMapper;
import com.whcm.report.domain.Banner;
import com.whcm.report.service.IBannerService;
import com.ruoyi.common.core.text.Convert;

/**
 * 轮播图 服务层实现
 * 
 * @author dong.chao
 * @date 2019-03-28
 */
@Service
public class BannerServiceImpl implements IBannerService 
{
	@Autowired
	private BannerMapper bannerMapper;

	/**
     * 查询轮播图信息
     * 
     * @param bannerId 轮播图ID
     * @return 轮播图信息
     */
    @Override
	public Banner selectBannerById(Integer bannerId)
	{
	    return bannerMapper.selectBannerById(bannerId);
	}
	
	/**
     * 查询轮播图列表
     * 
     * @param banner 轮播图信息
     * @return 轮播图集合
     */
	@Override
	public List<Banner> selectBannerList(Banner banner)
	{
	    return bannerMapper.selectBannerList(banner);
	}
	
    /**
     * 新增轮播图
     * 
     * @param banner 轮播图信息
     * @return 结果
     */
	@Override
	public int insertBanner(Banner banner)
	{
	    return bannerMapper.insertBanner(banner);
	}
	
	/**
     * 修改轮播图
     * 
     * @param banner 轮播图信息
     * @return 结果
     */
	@Override
	public int updateBanner(Banner banner)
	{
	    return bannerMapper.updateBanner(banner);
	}

	/**
     * 删除轮播图对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteBannerByIds(String ids)
	{
		return bannerMapper.deleteBannerByIds(Convert.toStrArray(ids));
	}
	
}
