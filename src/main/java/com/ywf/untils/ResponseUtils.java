package com.ywf.untils;

import javax.servlet.http.HttpServletResponse;

/**
 * HttpServletResponse工具方法
 * weifeng yang
 */
public class ResponseUtils {

	/**
	 * 以文本UTF8形式返回数据
	 * 
	 * @param response
	 *            HttpServletResponse
	 * @param text
	 */
	public static void renderText(HttpServletResponse response, String text) {
		render(response, "text/plain;charset=UTF-8", text);
	}

	public static void renderJson(HttpServletResponse response, String text) {
		render(response, "application/json;charset=UTF-8", text);
	}

	/**
	 * 以JSON UTF8形式返回数据
	 * 
	 * @param response
	 * @param contentType
	 * @param text
	 */
	public static void render(HttpServletResponse response, String contentType, String text) {
		response.setContentType(contentType);
		response.setCharacterEncoding("utf-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Access-Control-Max-Age", "3600"); // 设置过期时间
		try {
			response.getWriter().write(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
