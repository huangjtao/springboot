package com.mtl.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.mtl.common.tool.api.R;
import com.mtl.common.tool.model.Page;
import org.springframework.web.bind.annotation.*;
import com.mtl.system.domain.RoleAuth;
import com.mtl.system.service.IRoleAuthService;
import java.util.List;
import java.util.Arrays;

/**
 * 角色菜单表 控制器
 *
 * @author lsc
 * @since 2019-04-14
 */
@RestController
@RequestMapping("/roleauth")
@Api(value = "角色菜单表", tags = "角色菜单表接口")
public class RoleAuthController {

	private IRoleAuthService roleAuthService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入roleAuth", position = 1)
	public R<RoleAuth> detail(Integer id) {
		RoleAuth detail = roleAuthService.findById(id);
		return R.data(detail);
	}

	/**
	* 分页 角色菜单表
	*/
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入roleAuth", position = 2)
	public R<Page<RoleAuth>> page(Integer page,Integer size) {
		Page<RoleAuth> pages = roleAuthService.findPage(page,size);
		return R.data(pages);
	}

	/**
	* 新增或修改 角色菜单表
	*/
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入roleAuth", position = 6)
	public R submit(@RequestBody RoleAuth roleAuth) {
		return R.status(roleAuthService.saveOrUpdate(roleAuth));
	}

	/**
	* 删除 角色菜单表
	*/
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids", position = 7)
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody Integer[] ids) {
		return R.status(roleAuthService.deleteBatch(Arrays.asList(ids)));
	}

}
