package com.ywf.Controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ywf.service.ICommonUntilService;
import com.ywf.untils.ResponseUtils;

/**
 * 公共方法控制器
 * 
 * @author yangweifeng
 *
 */
@Controller
public class CommonUntilController {
	@Resource
	private ICommonUntilService commonUntilService;
	//private static final Logger logger = Logger.getLogger(CommonUntilController.class);

	/**
	 * 获取分类级联列表
	 * 
	 * @param response
	 */
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	@ResponseBody
	public void getInfo(HttpServletResponse response) {
		ResponseUtils.renderJson(response, "yangweifeng");
	}


}
