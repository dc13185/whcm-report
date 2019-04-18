package com.whcm.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.whcm.report.mapper.FeedbackMapper;
import com.whcm.report.domain.Feedback;
import com.whcm.report.service.IFeedbackService;
import com.ruoyi.common.core.text.Convert;

/**
 * 反馈 服务层实现
 * 
 * @author dong.chao
 * @date 2019-04-18
 */
@Service
public class FeedbackServiceImpl implements IFeedbackService 
{
	@Autowired
	private FeedbackMapper feedbackMapper;

	/**
     * 查询反馈信息
     * 
     * @param feedbackId 反馈ID
     * @return 反馈信息
     */
    @Override
	public Feedback selectFeedbackById(Integer feedbackId)
	{
	    return feedbackMapper.selectFeedbackById(feedbackId);
	}
	
	/**
     * 查询反馈列表
     * 
     * @param feedback 反馈信息
     * @return 反馈集合
     */
	@Override
	public List<Feedback> selectFeedbackList(Feedback feedback)
	{
	    return feedbackMapper.selectFeedbackList(feedback);
	}
	
    /**
     * 新增反馈
     * 
     * @param feedback 反馈信息
     * @return 结果
     */
	@Override
	public int insertFeedback(Feedback feedback)
	{
	    return feedbackMapper.insertFeedback(feedback);
	}
	
	/**
     * 修改反馈
     * 
     * @param feedback 反馈信息
     * @return 结果
     */
	@Override
	public int updateFeedback(Feedback feedback)
	{
	    return feedbackMapper.updateFeedback(feedback);
	}

	/**
     * 删除反馈对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFeedbackByIds(String ids)
	{
		return feedbackMapper.deleteFeedbackByIds(Convert.toStrArray(ids));
	}
	
}
