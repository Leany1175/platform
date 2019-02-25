package com.platform.controller;

import com.platform.entity.Administrator;
import com.platform.utils.ajax.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("prototype")
@RequestMapping("/administrator")
public class AdminBaseController {

	private static Logger logger = LoggerFactory.getLogger(AdminBaseController.class);

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

		// shiro登录
		Subject subject = SecurityUtils.getSubject();
		try {
			// 登录
			subject.login(new UsernamePasswordToken(admin.getPhone(), admin.getPassword()));
		} catch (AuthenticationException e) {
			logger.error("登录失败", e);
			return new Result(e.getMessage());
		}
		return new Result(200, "登录成功", "/");
	}

	/**
	 * 注销
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/loginOut", method = RequestMethod.GET)
	public Result loginOut() {
		// shiro注销
		SecurityUtils.getSubject().logout();
		return new Result(200, "注销成功", "/admin/index");
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
