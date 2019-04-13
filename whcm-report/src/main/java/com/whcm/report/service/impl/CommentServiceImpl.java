package com.whcm.report.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.whcm.report.mapper.CommentMapper;
import com.whcm.report.domain.Comment;
import com.whcm.report.service.ICommentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 节目评论 服务层实现
 *
 * @author dong.chao
 * @date 2019-04-07
 */
@Service
public class CommentServiceImpl implements ICommentService
{
	@Autowired
	private CommentMapper commentMapper;

	/**
	 * 查询节目评论信息
	 *
	 * @param comment 节目评论信息
	 * @return 节目评论信息
	 */
	@Override
	public Comment selectCommentByOpenIdAndProId(Comment comment)
	{
		return commentMapper.selectCommentByOpenIdAndProId(comment);
	}

	/**
	 * 查询节目评论列表
	 *
	 * @param comment 节目评论信息
	 * @return 节目评论集合
	 */
	@Override
	public List<Comment> selectCommentList(Comment comment)
	{
		return commentMapper.selectCommentList(comment);
	}

	/**
	 * 新增节目评论
	 *
	 * @param comment 节目评论信息
	 * @return 结果
	 */
	@Override
	public int insertComment(Comment comment)
	{
		return commentMapper.insertComment(comment);
	}

	/**
	 * 修改节目评论
	 *
	 * @param comment 节目评论信息
	 * @return 结果
	 */
	@Override
	public int updateComment(Comment comment)
	{
		return commentMapper.updateComment(comment);
	}

	/**
	 * 删除节目评论对象
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteCommentByIds(String ids)
	{
		return commentMapper.deleteCommentByIds(Convert.toStrArray(ids));
	}


	@Override
	public int selectComments(String wxUserOpenId) { return commentMapper.selectComments(wxUserOpenId); }

	@Override
	public Map getCommentsByOpenId(Integer commentId) {
		return commentMapper.getCommentsByOpenId(commentId);
	}
}
