package com.platform.repository;

import com.platform.entity.HdfsConnInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HdfsConnRepository extends JpaRepository<HdfsConnInfo, String> {



}
