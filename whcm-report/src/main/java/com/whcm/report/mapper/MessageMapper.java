package com.whcm.report.mapper;

import com.whcm.report.domain.Message;
import java.util.List;	

/**
 * 留言 数据层
 * 
 * @author dong.chao
 * @date 2019-04-09
 */
public interface MessageMapper 
{
	/**
     * 查询留言信息
     * 
     * @param messageId 留言ID
     * @return 留言信息
     */
	public Message selectMessageById(Integer messageId);
	
	/**
     * 查询留言列表
     * 
     * @param message 留言信息
     * @return 留言集合
     */
	public List<Message> selectMessageList(Message message);
	
	/**
     * 新增留言
     * 
     * @param message 留言信息
     * @return 结果
     */
	public int insertMessage(Message message);
	
	/**
     * 修改留言
     * 
     * @param message 留言信息
     * @return 结果
     */
	public int updateMessage(Message message);
	
	/**
     * 删除留言
     * 
     * @param messageId 留言ID
     * @return 结果
     */
	public int deleteMessageById(Integer messageId);
	
	/**
     * 批量删除留言
     * 
     * @param messageIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteMessageByIds(String[] messageIds);
	
}