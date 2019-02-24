package com.platform.service;

import com.platform.PlatformApplication;
import com.platform.entity.Administrator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PlatformApplication.class)
public class AdminServiceTest {

	@Autowired
	private AdminService adminService;

	@Test
	@Transactional
	public void loginTest() {
		String phone = "13000000000";
		String password = "123456";
		Administrator admin = new Administrator();
		admin.setPhone(phone);
		admin.setPassword(password);
		adminService.save(admin);

		Administrator administrator = adminService.login(phone, password);
		Assert.assertNotNull(administrator);
		Assert.assertEquals(phone, administrator.getPhone());

	}

}
