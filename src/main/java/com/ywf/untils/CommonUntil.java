package com.ywf.untils;

import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 通用工具方法
 * 
 * @author yangweifeng
 */
public class CommonUntil {
	public static SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat formatDate2 = new SimpleDateFormat("yyyy/MM/dd");
	public static SimpleDateFormat formatDate3 = new SimpleDateFormat("yyyyMMdd");
	public static SimpleDateFormat formatDateHMS = new SimpleDateFormat();
	public static SimpleDateFormat logDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 初始化后端返回标准json串
	 * 
	 * @return JSONObject
	 */
	public static JSONObject getJsonObject(JSONArray data, JSONObject pagination, String message, String status) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(Constants.RESPONSE_DATA, data);
		jsonObject.put(Constants.RESPONSE_PAGINATION, pagination);
		jsonObject.put(Constants.RESPONSE_MESSAGE, message);
		jsonObject.put(Constants.RESPONSE_STATUS, status);
		return jsonObject;
	}

}