package com.whcm.report.service;

import com.whcm.report.domain.Comment;
import java.util.List;

/**
 * 节目评论 服务层
 * 
 * @author dong.chao
 * @date 2019-04-07
 */
public interface ICommentService 
{
	/**
     * 查询节目评论信息
     * 
     * @param comment 节目评论信息
     * @return 节目评论信息
     */
	public Comment selectCommentByOpenIdAndProId(Comment comment);
	
	/**
     * 查询节目评论列表
     * 
     * @param comment 节目评论信息
     * @return 节目评论集合
     */
	public List<Comment> selectCommentList(Comment comment);
	
	/**
     * 新增节目评论
     * 
     * @param comment 节目评论信息
     * @return 结果
     */
	public int insertComment(Comment comment);
	
	/**
     * 修改节目评论
     * 
     * @param comment 节目评论信息
     * @return 结果
     */
	public int updateComment(Comment comment);
		
	/**
     * 删除节目评论信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCommentByIds(String ids);
	
}
