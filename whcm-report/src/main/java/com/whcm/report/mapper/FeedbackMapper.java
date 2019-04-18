package com.whcm.report.mapper;

import com.whcm.report.domain.Feedback;
import java.util.List;	

/**
 * 反馈 数据层
 * 
 * @author dong.chao
 * @date 2019-04-18
 */
public interface FeedbackMapper 
{
	/**
     * 查询反馈信息
     * 
     * @param feedbackId 反馈ID
     * @return 反馈信息
     */
	public Feedback selectFeedbackById(Integer feedbackId);
	
	/**
     * 查询反馈列表
     * 
     * @param feedback 反馈信息
     * @return 反馈集合
     */
	public List<Feedback> selectFeedbackList(Feedback feedback);
	
	/**
     * 新增反馈
     * 
     * @param feedback 反馈信息
     * @return 结果
     */
	public int insertFeedback(Feedback feedback);
	
	/**
     * 修改反馈
     * 
     * @param feedback 反馈信息
     * @return 结果
     */
	public int updateFeedback(Feedback feedback);
	
	/**
     * 删除反馈
     * 
     * @param feedbackId 反馈ID
     * @return 结果
     */
	public int deleteFeedbackById(Integer feedbackId);
	
	/**
     * 批量删除反馈
     * 
     * @param feedbackIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteFeedbackByIds(String[] feedbackIds);
	
}