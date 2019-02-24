package com.platform.controller;

import com.platform.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.platform.entity.Administrator;
import com.platform.utils.ajax.Result;

@Controller
@Scope("prototype")
@RequestMapping("/administrator")
public class AdminBaseController {

	private static Logger logger = LoggerFactory.getLogger(AdminBaseController.class);

	@Autowired
	private AdminService adminService;

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
		// 登录验证
		String message = validateLogin(admin);
		if (message != null) {
			logger.warn(message);
			return new Result(message);
		}

		Administrator administrator = adminService.login(admin.getPhone(), admin.getPassword());
		if (administrator == null) {
			return new Result("用户名或密码错误");
		}

		// TODO shiro登录
		return new Result(200, "登录成功", "/");
	}

	/**
	 * 登录验证
	 * @param admin 登录信息
	 * @return 验证结果
	 */
	private String validateLogin(Administrator admin) {
		if (admin.getPhone() == null || admin.getPhone().isEmpty()) {
			return "手机号不能为空";
		}
		// TODO 手机号格式
		// 密码非空
		if (admin.getPassword() == null || admin.getPassword().isEmpty()) {
			return "密码不能为空";
		}
		int length = admin.getPassword().length();
		// 密码长度
		if (length < 6 || length > 32) {
			return "密码长度应在6-32位之间";
		}
		return null;
	}

}
