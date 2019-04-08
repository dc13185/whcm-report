package com.whcm.report.service;

import com.whcm.report.domain.Vote;
import java.util.List;

/**
 * 投票 服务层
 * 
 * @author dong.chao
 * @date 2019-04-08
 */
public interface IVoteService 
{
	/**
     * 查询投票信息
     * 
     * @param vote 投票信息
     * @return 投票信息
     */
	public Vote selectVoteById(Vote vote);
	
	/**
     * 查询投票列表
     * 
     * @param vote 投票信息
     * @return 投票集合
     */
	public List<Vote> selectVoteList(Vote vote);
	
	/**
     * 新增投票
     * 
     * @param vote 投票信息
     * @return 结果
     */
	public int insertVote(Vote vote);
	
	/**
     * 修改投票
     * 
     * @param vote 投票信息
     * @return 结果
     */
	public int updateVote(Vote vote);
		
	/**
     * 删除投票信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteVoteByIds(String ids);


	/**
	 * 获取某一个人的投票数
	 *
	 * @param openId
	 * @return 结果
	 */
	public Integer selectVotesByOpenId(String openId);


	/**
	 * 获取某一个节目的投票数
	 *
	 * @param programId
	 * @return 结果
	 */
	public Integer selectVotesByProId(Integer programId);

}
