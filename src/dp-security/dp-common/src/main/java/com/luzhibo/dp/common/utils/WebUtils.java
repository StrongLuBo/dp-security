package com.luzhibo.dp.common.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;

import com.luzhibo.dp.common.entity.Query;

/**
 * web工具类
 * @author 89754
 */
public class WebUtils {
	
	/**
	 * 是否为ajax请求
	 * @param request
	 * @return boolean
	 */
	public static boolean isAjax(HttpServletRequest request){
		//如果是ajax请求响应头会有，x-requested-with
		 if (request.getHeader("x-requested-with") != null    
				 && request.getHeader("x-requested-with")    
				 .equalsIgnoreCase("XMLHttpRequest")) { 
			 return true;
		 }
		 return false;
	}
	
	/**
	 * 页面输出
	 * @param response
	 * @param o
	 */
	public static void write(HttpServletResponse response,Object o){
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println(o.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 将用户信息封装到map中
	 */
	public static Query getCurrUserMap() {
		Object userObj = SecurityUtils.getSubject().getPrincipal();
		if(CommonUtils.isNullOrEmpty(userObj)) {
			Query error = new Query();
			error.put("username", "获取用户信息失败");
			return error;
		}
		String username = JSONUtils.beanToJson(userObj);
		Map<String, Object> currUser = JSONUtils.jsonToMap(username);
		Query query = new Query(currUser);
		return query;
	}

}
