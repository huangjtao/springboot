package com.mtl.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.mtl.common.tool.api.R;
import com.mtl.common.tool.model.Page;
import org.springframework.web.bind.annotation.*;
import com.mtl.system.domain.Department;
import com.mtl.system.service.IDepartmentService;
import java.util.List;
import java.util.Arrays;

/**
 *  控制器
 *
 * @author lsc
 * @since 2019-04-06
 */
@RestController
@RequestMapping("/department")
@Api(value = "", tags = "接口")
public class DepartmentController {

	private IDepartmentService departmentService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入department", position = 1)
	public R<Department> detail(Integer id) {
		Department detail = departmentService.findById(id);
		return R.data(detail);
	}

	/**
	* 分页 
	*/
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入department", position = 2)
	public R<Page<Department>> page(Integer page,Integer size) {
		Page<Department> pages = departmentService.findPage(page,size);
		return R.data(pages);
	}

	/**
	* 新增或修改 
	*/
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入department", position = 6)
	public R submit(@RequestBody Department department) {
		return R.status(departmentService.saveOrUpdate(department));
	}

	/**
	* 删除 
	*/
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids", position = 7)
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody Integer[] ids) {
		return R.status(departmentService.deleteBatch(Arrays.asList(ids)));
	}

}
