package com.whcm.report.controller;

import java.util.List;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.whcm.report.domain.Type;
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
import com.whcm.report.service.ITypeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;

/**
 * 节目类型 信息操作处理
 * 
 * @author dong.chao
 * @date 2019-04-02
 */
@Controller
@RequestMapping("/report/type")
public class TypeController extends BaseController
{
    private String prefix = "report/type";
	
	@Autowired
	private ITypeService typeService;
	
	@RequiresPermissions("report:type:view")
	@GetMapping()
	public String type()
	{
	    return prefix + "/type";
	}
	
	/**
	 * 查询节目类型列表
	 */
	@RequiresPermissions("report:type:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Type type)
	{
		startPage();
        List<Type> list = typeService.selectTypeList(type);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出节目类型列表
	 */
	@RequiresPermissions("report:type:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Type type)
    {
    	List<Type> list = typeService.selectTypeList(type);
        ExcelUtil<Type> util = new ExcelUtil<Type>(Type.class);
        return util.exportExcel(list, "type");
    }
	
	/**
	 * 新增节目类型
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存节目类型
	 */
	@RequiresPermissions("report:type:add")
	@Log(title = "节目类型", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Type type)
	{		
		return toAjax(typeService.insertType(type));
	}

	/**
	 * 修改节目类型
	 */
	@GetMapping("/edit/{typeId}")
	public String edit(@PathVariable("typeId") Integer typeId, ModelMap mmap)
	{
		Type type = typeService.selectTypeById(typeId);
		mmap.put("type", type);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存节目类型
	 */
	@RequiresPermissions("report:type:edit")
	@Log(title = "节目类型", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Type type)
	{		
		return toAjax(typeService.updateType(type));
	}
	
	/**
	 * 删除节目类型
	 */
	@RequiresPermissions("report:type:remove")
	@Log(title = "节目类型", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(typeService.deleteTypeByIds(ids));
	}
	
}
