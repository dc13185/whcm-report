package com.whcm.report.mapper;

import com.whcm.report.domain.Fabulous;
import java.util.List;	

/**
 * 点赞 数据层
 * 
 * @author dong.chao
 * @date 2019-04-08
 */
public interface FabulousMapper 
{
	/**
     * 查询点赞信息
     * 
     * @param fabulous 点赞信息
     * @return 点赞信息
     */
	public Fabulous selectFabulousByOpIdAndProId(Fabulous fabulous);
	
	/**
     * 查询点赞列表
     * 
     * @param fabulous 点赞信息
     * @return 点赞集合
     */
	public List<Fabulous> selectFabulousList(Fabulous fabulous);
	
	/**
     * 新增点赞
     * 
     * @param fabulous 点赞信息
     * @return 结果
     */
	public int insertFabulous(Fabulous fabulous);
	
	/**
     * 修改点赞
     * 
     * @param fabulous 点赞信息
     * @return 结果
     */
	public int updateFabulous(Fabulous fabulous);
	
	/**
     * 删除点赞
     * 
     * @param fabulousId 点赞ID
     * @return 结果
     */
	public int deleteFabulousById(Integer fabulousId);
	
	/**
     * 批量删除点赞
     * 
     * @param fabulousIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteFabulousByIds(String[] fabulousIds);


	/**
	 * 获取点赞数量
	 *
	 * @param programId 节目id
	 * @return 结果
	 */
	public Integer selectFabulousByProId(Integer programId);
	
}