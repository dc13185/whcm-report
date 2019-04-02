package com.whcm.report.service;

import com.whcm.report.domain.Type;
import java.util.List;

/**
 * 节目类型 服务层
 * 
 * @author dong.chao
 * @date 2019-04-02
 */
public interface ITypeService 
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


	public List<Type> selectTypeAll();
	
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
     * 删除节目类型信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTypeByIds(String ids);
	
}
