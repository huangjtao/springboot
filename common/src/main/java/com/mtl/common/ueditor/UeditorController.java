package com.mtl.common.ueditor;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * 用于处理关于ueditor插件相关的请求
 * @author Guoqing
 * @date 2017-11-29
 *
 */
@RestController
@CrossOrigin
@RequestMapping("ueditor")
public class UeditorController {

	@RequestMapping(value = "/exec")
	@ResponseBody
	public Object exec(HttpServletRequest request) throws UnsupportedEncodingException, JSONException{
		System.out.println("ueditor");
		request.setCharacterEncoding("utf-8");
		return new ActionEnter(request).exec();
	}
	
}
