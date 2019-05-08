package com.platform.repository;

import com.platform.entity.TreeBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreeRepository extends JpaRepository<TreeBean, String> {



}
