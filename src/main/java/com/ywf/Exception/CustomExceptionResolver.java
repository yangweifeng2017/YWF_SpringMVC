package com.ywf.Exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.ywf.untils.CommonUntil;
import com.ywf.untils.Constants;
import com.ywf.untils.ResponseUtils;

/**
 * 自定义异常类,针对预期的异常进行处理
 * 
 * @author yangweifeng
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
	private static final Logger logger = Logger.getLogger(CustomExceptionResolver.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		String message = "系统错误:请联系管理员";
		logger.error("系统错误:请联系管理员--" + ex.getMessage());
		JSONObject jsonObject = CommonUntil.getJsonObject(null, null, message, Constants.ERROR);
		ResponseUtils.renderJson(response, jsonObject.toJSONString());
		return null;
	}
}
