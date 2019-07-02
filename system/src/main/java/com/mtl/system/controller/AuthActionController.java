package com.mtl.system.controller;

import com.mtl.common.tool.api.R;
import com.mtl.common.tool.model.Page;
import com.mtl.common.tool.utils.Func;
import com.mtl.system.domain.AuthAction;
import com.mtl.system.service.IAuthActionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 *  控制器
 *
 * @author lsc
 * @since 2019-03-26
 */
@RestController
@AllArgsConstructor
@RequestMapping("/authaction")
@Api(value = "菜单管理", tags = "权限")
public class AuthActionController {

	private IAuthActionService authActionService;



	/**
	* 详情
	*/
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入authAction", position = 1)
	public R<AuthAction> detail(Integer id) {
		AuthAction detail = authActionService.findById(id);
		return R.data(detail);
	}

	/**
	* 分页 
	*/
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入authAction", position = 2)
	public R<Page<AuthAction>> list(Integer page,Integer size) {
		Page<AuthAction> pages = authActionService.findPage(page,size);
		return R.data(pages);
	}


	/**
	* 新增或修改 
	*/
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入authAction", position = 6)
	public R submit(@Valid @RequestBody AuthAction authAction) {
		return R.status(authActionService.saveOrUpdate(authAction));
	}

	
	/**
	* 删除 
	*/
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids", position = 7)
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody Integer[] ids) {
		return R.status(authActionService.deleteBatch(Arrays.asList(ids)));
	}
	
}
