package com.platform.repository;

import com.platform.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Administrator, String> {

	Administrator findByPhoneAndPassword(String phone, String password);

}
