/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mtl.common.oss;

import com.mtl.common.tool.api.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * 图片上传
 *
 * @author Sami
 * @since 2019-03-26
 */
@RestController
@RequestMapping("/image")
@Api(value = "图片上传", tags = "图片上传")
public class imgUploadController {

	@RequestMapping(value = "/imageUpload",method = RequestMethod.POST)
	@ApiOperation(value = "WebUploader图片上传")
	public String uploadFile(@RequestParam("file") MultipartFile files,
							 HttpServletRequest request){

		String imagePath=null;
		String fileName=files.getOriginalFilename();
		try {
			//上传七牛云服务器
			imagePath= QiniuUtil.qiniuUpload(files.getBytes(),fileName);
			if(imagePath.contains("error")){
				System.out.println("上传失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imagePath;
	}

	@RequestMapping(value = "/delImage",method = RequestMethod.GET)
	@ApiOperation(value = "删除图片")
	public Object delFile(@RequestParam("url") String url){
		String str=QiniuUtil.delFile(url);
		return  str;
	}

}
