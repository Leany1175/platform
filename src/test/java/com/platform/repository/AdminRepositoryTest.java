package com.platform.repository;

import com.platform.PlatformApplication;
import com.platform.entity.Administrator;
import com.platform.utils.ajax.utils.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PlatformApplication.class)
public class AdminRepositoryTest {

	@Autowired
	private AdminRepository adminRepository;

	@Test
	@Transactional
	public void saveTest() {
		Administrator admin = new Administrator();
		String phone = "15000000000";
		String password = StringUtils.encodeMD5("123456");
		admin.setPhone(phone);
		admin.setPassword(password);
		admin.setCreateTime(new Date());
		adminRepository.save(admin);
		Assert.assertEquals(phone, admin.getPhone());
		Assert.assertEquals(password, admin.getPassword());
		Assert.assertNotNull(admin.getAdminId());
	}


}
