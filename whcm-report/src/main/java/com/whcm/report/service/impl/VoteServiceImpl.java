package com.whcm.report.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.whcm.report.mapper.VoteMapper;
import com.whcm.report.domain.Vote;
import com.whcm.report.service.IVoteService;
import com.ruoyi.common.core.text.Convert;

/**
 * 投票 服务层实现
 * 
 * @author dong.chao
 * @date 2019-04-08
 */
@Service
public class VoteServiceImpl implements IVoteService 
{
	@Autowired
	private VoteMapper voteMapper;

	/**
     * 查询投票信息
     * 
     * @param voteId 投票ID
     * @return 投票信息
     */
    @Override
	public Vote selectVoteById(Vote vote)
	{
	    return voteMapper.selectVoteById(vote);
	}
	
	/**
     * 查询投票列表
     * 
     * @param vote 投票信息
     * @return 投票集合
     */
	@Override
	public List<Vote> selectVoteList(Vote vote)
	{
	    return voteMapper.selectVoteList(vote);
	}
	
    /**
     * 新增投票
     * 
     * @param vote 投票信息
     * @return 结果
     */
	@Override
	public int insertVote(Vote vote)
	{
	    return voteMapper.insertVote(vote);
	}
	
	/**
     * 修改投票
     * 
     * @param vote 投票信息
     * @return 结果
     */
	@Override
	public int updateVote(Vote vote)
	{
	    return voteMapper.updateVote(vote);
	}

	/**
     * 删除投票对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteVoteByIds(String ids)
	{
		return voteMapper.deleteVoteByIds(Convert.toStrArray(ids));
	}


	/**
	 * 获取投票数
	 *
	 * @param openId
	 * @return 结果
	 */
	@Override
	public Integer selectVotesByOpenId(String openId) {
		return voteMapper.selectVotesByOpenId(openId);
	}


	@Override
	public Integer selectVotesByProId(Integer programId) {
		return voteMapper.selectVotesByProId(programId);
	}


	@Override
	public List<Object> selectAllVotes() {
		return voteMapper.selectAllVotes();
	}


	@Override
	public List<HashMap> getVotesByOpenId(String openId) {
		return voteMapper.getVotesByOpenId(openId);
	}

	@Override
	public String selectVoteCount() {
		return voteMapper.selectVoteCount();
	}
}
