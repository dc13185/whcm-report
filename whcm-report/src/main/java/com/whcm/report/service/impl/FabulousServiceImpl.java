package com.whcm.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.whcm.report.mapper.FabulousMapper;
import com.whcm.report.domain.Fabulous;
import com.whcm.report.service.IFabulousService;
import com.ruoyi.common.core.text.Convert;

/**
 * 点赞 服务层实现
 * 
 * @author dong.chao
 * @date 2019-04-08
 */
@Service
public class FabulousServiceImpl implements IFabulousService 
{
	@Autowired
	private FabulousMapper fabulousMapper;

	/**
     * 查询点赞信息
     * 
     * @param fabulousId 点赞ID
     * @return 点赞信息
     */
    @Override
	public Fabulous selectFabulousByOpIdAndProId(Fabulous Fabulous)
	{
	    return fabulousMapper.selectFabulousByOpIdAndProId(Fabulous);
	}
	
	/**
     * 查询点赞列表
     * 
     * @param fabulous 点赞信息
     * @return 点赞集合
     */
	@Override
	public List<Fabulous> selectFabulousList(Fabulous fabulous)
	{
	    return fabulousMapper.selectFabulousList(fabulous);
	}
	
    /**
     * 新增点赞
     * 
     * @param fabulous 点赞信息
     * @return 结果
     */
	@Override
	public int insertFabulous(Fabulous fabulous)
	{
	    return fabulousMapper.insertFabulous(fabulous);
	}
	
	/**
     * 修改点赞
     * 
     * @param fabulous 点赞信息
     * @return 结果
     */
	@Override
	public int updateFabulous(Fabulous fabulous)
	{
	    return fabulousMapper.updateFabulous(fabulous);
	}

	/**
     * 删除点赞对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFabulousByIds(String ids)
	{
		return fabulousMapper.deleteFabulousByIds(Convert.toStrArray(ids));
	}



	/**
	 * 获取点赞数量
	 *
	 * @param programId 节目id
	 * @return 结果
	 */
	@Override
	public Integer selectFabulousByProId(Integer programId) {
		return fabulousMapper.selectFabulousByProId(programId);
	}
}
