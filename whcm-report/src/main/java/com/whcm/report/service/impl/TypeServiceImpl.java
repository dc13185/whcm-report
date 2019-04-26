package com.whcm.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.whcm.report.mapper.TypeMapper;
import com.whcm.report.domain.Type;
import com.whcm.report.service.ITypeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 节目类型 服务层实现
 *
 * @author dong.chao
 * @date 2019-04-02
 */
@Service
public class TypeServiceImpl implements ITypeService
{
	@Autowired
	private TypeMapper typeMapper;

	/**
	 * 查询节目类型信息
	 *
	 * @param typeId 节目类型ID
	 * @return 节目类型信息
	 */
	@Override
	public Type selectTypeById(Integer typeId)
	{
		return typeMapper.selectTypeById(typeId);
	}

	/**
	 * 查询节目类型列表
	 *
	 * @param type 节目类型信息
	 * @return 节目类型集合
	 */
	@Override
	public List<Type> selectTypeList(Type type)
	{
		return typeMapper.selectTypeList(type);
	}

	/**
	 * 新增节目类型
	 *
	 * @param type 节目类型信息
	 * @return 结果
	 */
	@Override
	public int insertType(Type type)
	{
		return typeMapper.insertType(type);
	}

	/**
	 * 修改节目类型
	 *
	 * @param type 节目类型信息
	 * @return 结果
	 */
	@Override
	public int updateType(Type type)
	{
		return typeMapper.updateType(type);
	}

	/**
	 * 删除节目类型对象
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteTypeByIds(String ids)
	{
		return typeMapper.deleteTypeByIds(Convert.toStrArray(ids));
	}

	@Override
	public Type selectTypeByProId(Integer program_id) {
		return typeMapper.selectTypeByProId(program_id);
	}

	@Override
	public List<Type> selectTypeAll() {
		return typeMapper.selectTypeAll();
	}
}
