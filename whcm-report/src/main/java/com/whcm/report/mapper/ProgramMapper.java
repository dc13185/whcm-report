package com.whcm.report.mapper;

import com.whcm.report.domain.Program;
import com.whcm.report.domain.Type;

import java.util.List;

/**
 * 节目 数据层
 * 
 * @author dong.chao
 * @date 2019-04-02
 */
public interface ProgramMapper 
{
	/**
     * 查询节目信息
     * 
     * @param programId 节目ID
     * @return 节目信息
     */
	public Program selectProgramById(Integer programId);
	
	/**
     * 查询节目列表
     * 
     * @param program 节目信息
     * @return 节目集合
     */
	public List<Program> selectProgramList(Program program);

	public List<Program> selectProgramListVotes(Program program);
	
	/**
     * 新增节目
     * 
     * @param program 节目信息
     * @return 结果
     */
	public int insertProgram(Program program);
	
	/**
     * 修改节目
     * 
     * @param program 节目信息
     * @return 结果
     */
	public int updateProgram(Program program);
	
	/**
     * 删除节目
     * 
     * @param programId 节目ID
     * @return 结果
     */
	public int deleteProgramById(Integer programId);
	
	/**
     * 批量删除节目
     * 
     * @param programIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteProgramByIds(String[] programIds);



	
}