package com.whcm.report.controller;

import java.util.List;

import com.whcm.report.domain.Type;
import com.whcm.report.service.ITypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.whcm.report.domain.Program;
import com.whcm.report.service.IProgramService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 节目 信息操作处理
 * 
 * @author dong.chao
 * @date 2019-04-02
 */
@Controller
@RequestMapping("/report/program")
public class ProgramController extends BaseController
{
    private String prefix = "report/program";
	
	@Autowired
	private IProgramService programService;

	@Autowired
	private ITypeService typeService;
	
	@RequiresPermissions("report:program:view")
	@GetMapping()
	public String program()
	{
	    return prefix + "/program";
	}
	
	/**
	 * 查询节目列表
	 */
	@RequiresPermissions("report:program:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Program program)
	{
		startPage();
        List<Program> list = programService.selectProgramList(program);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出节目列表
	 */
	@RequiresPermissions("report:program:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Program program)
    {
    	List<Program> list = programService.selectProgramList(program);
        ExcelUtil<Program> util = new ExcelUtil<Program>(Program.class);
        return util.exportExcel(list, "program");
    }
	
	/**
	 * 新增节目
	 */
	@GetMapping("/add")
	public String add(ModelMap modelMap)
	{
		List<Type> types =  typeService.selectTypeAll();
		modelMap.put("types",types);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存节目
	 */
	@RequiresPermissions("report:program:add")
	@Log(title = "节目", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Program program)
	{		
		return toAjax(programService.insertProgram(program));
	}

	/**
	 * 修改节目
	 */
	@GetMapping("/edit/{programId}")
	public String edit(@PathVariable("programId") Integer programId, ModelMap mmap)
	{
		Program program = programService.selectProgramById(programId);
		mmap.put("program", program);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存节目
	 */
	@RequiresPermissions("report:program:edit")
	@Log(title = "节目", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Program program)
	{		
		return toAjax(programService.updateProgram(program));
	}
	
	/**
	 * 删除节目
	 */
	@RequiresPermissions("report:program:remove")
	@Log(title = "节目", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(programService.deleteProgramByIds(ids));
	}
	
}
