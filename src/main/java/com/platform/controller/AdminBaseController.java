package com.platform.controller;

import com.alibaba.fastjson.JSON;
import com.platform.entity.Administrator;
import com.platform.utils.ajax.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("prototype")
@RequestMapping("/administrator")
public class AdminBaseController {

	/**
	 * 登录界面
	 * @return 登录界面路径
	 */
	@RequestMapping("/loginPage")
	public String loginPage() {
		return "admin/login";
	}

	/**
	 * 登录操作
	 * @param admin 登录
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping(value = "/login")
	public Result login(Administrator admin) {
		System.out.println(JSON.toJSONString(admin));
		return new Result(200, "登录成功", "");
	}

}
