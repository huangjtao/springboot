package com.mtl.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.mtl.common.tool.api.R;
import com.mtl.common.tool.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mtl.system.domain.LogiCompany;
import com.mtl.system.service.ILogiCompanyService;
import java.util.List;
import java.util.Arrays;

/**
 *  控制器
 *
 * @author lsc
 * @since 2019-04-24
 */
@RestController
@RequestMapping("/logicompany")
@Api(value = "", tags = "接口")
public class LogiCompanyController {

	@Autowired
	private ILogiCompanyService logiCompanyService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入logiCompany", position = 1)
	public R<LogiCompany> detail(Integer id) {
		LogiCompany detail = logiCompanyService.findById(id);
		return R.data(detail);
	}

	/**
	* 分页 
	*/
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入logiCompany", position = 2)
	public R<Page<LogiCompany>> page(Integer page,Integer size) {
		Page<LogiCompany> pages = logiCompanyService.findPage(page,size);
		return R.data(pages);
	}

	/**
	* 新增或修改 
	*/
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入logiCompany", position = 6)
	public R submit(@RequestBody LogiCompany logiCompany) {
		return R.status(logiCompanyService.saveOrUpdate(logiCompany));
	}

	/**
	* 删除 
	*/
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids", position = 7)
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody Integer[] ids) {
		return R.status(logiCompanyService.deleteBatch(Arrays.asList(ids)));
	}

}
