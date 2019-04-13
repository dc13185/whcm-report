package com.whcm.report.service;

import com.whcm.report.domain.Comment;
import java.util.List;
import java.util.Map;

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
	
	
	/** 
	* @Description: 获取到投票数 
	* @Param: [wxUserOpenId] 
	* @return: int 
	* @Author: dong.chao
	* @Date: 2019/4/12 
	*/ 
	public int selectComments(String wxUserOpenId);
	
	
	/** 
	* @Description: 获取到用户投票的具体信息
	* @Param: [wxUserOpenId] 
	* @return: java.util.Map 
	* @Author: dong.chao
	* @Date: 2019/4/12 
	*/ 
    Map getCommentsByOpenId(Integer commentId);
}
