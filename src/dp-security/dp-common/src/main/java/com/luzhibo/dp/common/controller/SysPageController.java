package com.luzhibo.dp.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统页面视图
 * @author 89754
 */
@Controller
public class SysPageController {

	/**
	 * 页面跳转
	 * @param module
	 * @param function
	 * @param url
	 * @return String
	 */
	@RequestMapping("{module}/{function}/{url}.html")
	public String page(@PathVariable("module") String module, @PathVariable("function") String function,
			@PathVariable("url") String url) {
		return module + "/" + function + "/" + url + ".html";
	}
	
	/**
	 * 页面跳转
	 * @param module
	 * @param url
	 * @return String
	 */
	@RequestMapping("{module}/{url}.html")
	public String page(@PathVariable("module") String module, @PathVariable("url") String url) {
		return module + "/" + url + ".html";
	}

}
