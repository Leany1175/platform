package com.platform.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("prototype")
@RequestMapping("/admin/data")
public class DataController {

	/**
	 * 数据管理页面
	 * @return 路径
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String page() {
		return "admin/data/data-manager";
	}

}
