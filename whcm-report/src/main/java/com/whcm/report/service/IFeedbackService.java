package com.whcm.report.service;

import com.whcm.report.domain.Feedback;
import java.util.List;

/**
 * 反馈 服务层
 * 
 * @author dong.chao
 * @date 2019-04-18
 */
public interface IFeedbackService 
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
     * 删除反馈信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFeedbackByIds(String ids);
	
}
