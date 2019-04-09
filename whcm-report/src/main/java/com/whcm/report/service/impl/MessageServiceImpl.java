package com.whcm.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.whcm.report.mapper.MessageMapper;
import com.whcm.report.domain.Message;
import com.whcm.report.service.IMessageService;
import com.ruoyi.common.core.text.Convert;

/**
 * 留言 服务层实现
 * 
 * @author dong.chao
 * @date 2019-04-09
 */
@Service
public class MessageServiceImpl implements IMessageService 
{
	@Autowired
	private MessageMapper messageMapper;

	/**
     * 查询留言信息
     * 
     * @param messageId 留言ID
     * @return 留言信息
     */
    @Override
	public Message selectMessageById(Integer messageId)
	{
	    return messageMapper.selectMessageById(messageId);
	}
	
	/**
     * 查询留言列表
     * 
     * @param message 留言信息
     * @return 留言集合
     */
	@Override
	public List<Message> selectMessageList(Message message)
	{
	    return messageMapper.selectMessageList(message);
	}
	
    /**
     * 新增留言
     * 
     * @param message 留言信息
     * @return 结果
     */
	@Override
	public int insertMessage(Message message)
	{
	    return messageMapper.insertMessage(message);
	}
	
	/**
     * 修改留言
     * 
     * @param message 留言信息
     * @return 结果
     */
	@Override
	public int updateMessage(Message message)
	{
	    return messageMapper.updateMessage(message);
	}

	/**
     * 删除留言对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMessageByIds(String ids)
	{
		return messageMapper.deleteMessageByIds(Convert.toStrArray(ids));
	}
	
}
