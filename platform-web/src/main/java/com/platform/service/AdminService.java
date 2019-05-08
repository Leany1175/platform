package com.platform.service;

import com.platform.entity.Administrator;

public interface AdminService {

	/**
	 * 登录查询
	 * @param phone 手机号
	 * @param password  密码(未加密)
	 * @return 查询结果
	 */
	Administrator login(String phone, String password);

	/**
	 * 保存
	 * @param administrator 管理员信息
	 * @return 结果
	 */
	Administrator save(Administrator administrator);

}
