package com.whcm.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.whcm.report.mapper.ProgramMapper;
import com.whcm.report.domain.Program;
import com.whcm.report.service.IProgramService;
import com.ruoyi.common.core.text.Convert;

/**
 * 节目 服务层实现
 * 
 * @author dong.chao
 * @date 2019-04-02
 */
@Service
public class ProgramServiceImpl implements IProgramService 
{
	@Autowired
	private ProgramMapper programMapper;

	/**
     * 查询节目信息
     * 
     * @param programId 节目ID
     * @return 节目信息
     */
    @Override
	public Program selectProgramById(Integer programId)
	{
	    return programMapper.selectProgramById(programId);
	}
	
	/**
     * 查询节目列表
     * 
     * @param program 节目信息
     * @return 节目集合
     */
	@Override
	public List<Program> selectProgramList(Program program)
	{
	    return programMapper.selectProgramList(program);
	}
	
    /**
     * 新增节目
     * 
     * @param program 节目信息
     * @return 结果
     */
	@Override
	public int insertProgram(Program program)
	{
	    return programMapper.insertProgram(program);
	}
	
	/**
     * 修改节目
     * 
     * @param program 节目信息
     * @return 结果
     */
	@Override
	public int updateProgram(Program program)
	{
	    return programMapper.updateProgram(program);
	}

	/**
     * 删除节目对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteProgramByIds(String ids)
	{
		return programMapper.deleteProgramByIds(Convert.toStrArray(ids));
	}
	
}
