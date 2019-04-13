package com.whcm.report.service;

import com.whcm.report.domain.Fabulous;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 点赞 服务层
 * 
 * @author dong.chao
 * @date 2019-04-08
 */
public interface IFabulousService 
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
     * 删除点赞信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFabulousByIds(String ids);


	/**
	 * 获取点赞数量
	 *
	 * @param programId 节目Id
	 * @return 结果
	 */
	public Integer selectFabulousByProId(Integer programId);
	
	
	/** 
	* @Description: 获取点赞和投票的总数量
	* @Param: [wxUserOpenId] 
	* @return: java.lang.Integer 
	* @Author: dong.chao
	* @Date: 2019/4/12 
	*/ 
	public Integer  selectFabulousAndVotes(String wxUserOpenId);

	public Integer  selectFabulous(String wxUserOpenId);

	public Integer  selectVotes(String wxUserOpenId);

    List<HashMap> getFabulousByOpenId(String openId);

}
