package com.whcm.report.mapper;

import com.whcm.report.domain.Comment;
import java.util.List;
import java.util.Map;

/**
 * 节目评论 数据层
 * 
 * @author dong.chao
 * @date 2019-04-07
 */
public interface CommentMapper 
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
     * 删除节目评论
     * 
     * @param commentId 节目评论ID
     * @return 结果
     */
	public int deleteCommentById(Integer commentId);
	
	/**
     * 批量删除节目评论
     * 
     * @param commentIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteCommentByIds(String[] commentIds);


	/**
	 * 查看评论数量
	 *
	 * @param wxUserOpenId openId
	 * @return 结果
	 */
	public int selectComments(String wxUserOpenId);



	public Map getCommentsByOpenId(Integer commentId);
	
}