package com.platform.quartz.repository;

import com.platform.quartz.entity.JobDetailKey;
import com.platform.quartz.entity.QuartzJobDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobDetailRepository extends JpaRepository<QuartzJobDetails, JobDetailKey> {



}
