package com.whcm.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.whcm.report.mapper.WxUserMapper;
import com.whcm.report.domain.WxUser;
import com.whcm.report.service.IWxUserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 小程序用户 服务层实现
 *
 * @author dong.chao
 * @date 2019-04-07
 */
@Service
public class WxUserServiceImpl implements IWxUserService
{
	@Autowired
	private WxUserMapper wxUserMapper;

	/**
	 * 查询小程序用户信息
	 *
	 * @param wxUserOpenid 小程序用户ID
	 * @return 小程序用户信息
	 */
	@Override
	public WxUser selectWxUserById(String wxUserOpenid)
	{
		return wxUserMapper.selectWxUserById(wxUserOpenid);
	}

	/**
	 * 查询小程序用户列表
	 *
	 * @param wxUser 小程序用户信息
	 * @return 小程序用户集合
	 */
	@Override
	public List<WxUser> selectWxUserList(WxUser wxUser)
	{
		return wxUserMapper.selectWxUserList(wxUser);
	}

	/**
	 * 新增小程序用户
	 *
	 * @param wxUser 小程序用户信息
	 * @return 结果
	 */
	@Override
	public int insertWxUser(WxUser wxUser)
	{
		return wxUserMapper.insertWxUser(wxUser);
	}

	/**
	 * 修改小程序用户
	 *
	 * @param wxUser 小程序用户信息
	 * @return 结果
	 */
	@Override
	public int updateWxUser(WxUser wxUser)
	{
		return wxUserMapper.updateWxUser(wxUser);
	}

	/**
	 * 删除小程序用户对象
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteWxUserByIds(String ids)
	{
		return wxUserMapper.deleteWxUserByIds(Convert.toStrArray(ids));
	}

}
