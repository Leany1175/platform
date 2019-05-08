package com.platform.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.entity.Administrator;
import com.platform.repository.AdminRepository;
import com.platform.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	private static Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Administrator login(String phone, String password) {
		logger.info("登录查询,手机号:{}", phone);
		Administrator admin = adminRepository.findByPhoneAndPassword(phone, password);
		// 清空密码
		if (admin != null) {
			admin.setPassword("");
		}
		logger.info("登录查询结果:{}", admin);
		return admin;
	}

	@Override
	public Administrator save(Administrator administrator) {
		logger.info("管理员保存:{}", administrator);
		adminRepository.save(administrator);
		logger.info("管理员保存结果:{}", administrator);
		return administrator;
	}
}
