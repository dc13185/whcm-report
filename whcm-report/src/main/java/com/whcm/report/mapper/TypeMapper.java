package com.whcm.report.mapper;

import com.whcm.report.domain.Type;
import java.util.List;	

/**
 * 节目类型 数据层
 * 
 * @author dong.chao
 * @date 2019-04-02
 */
public interface TypeMapper 
{
	/**
     * 查询节目类型信息
     * 
     * @param typeId 节目类型ID
     * @return 节目类型信息
     */
	public Type selectTypeById(Integer typeId);
	
	/**
     * 查询节目类型列表
     * 
     * @param type 节目类型信息
     * @return 节目类型集合
     */
	public List<Type> selectTypeList(Type type);
	
	/**
     * 新增节目类型
     * 
     * @param type 节目类型信息
     * @return 结果
     */
	public int insertType(Type type);
	
	/**
     * 修改节目类型
     * 
     * @param type 节目类型信息
     * @return 结果
     */
	public int updateType(Type type);
	
	/**
     * 删除节目类型
     * 
     * @param typeId 节目类型ID
     * @return 结果
     */
	public int deleteTypeById(Integer typeId);
	
	/**
     * 批量删除节目类型
     * 
     * @param typeIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTypeByIds(String[] typeIds);

	public List<Type> selectTypeAll();


	Type selectTypeByProId(Integer program_id);


	
}