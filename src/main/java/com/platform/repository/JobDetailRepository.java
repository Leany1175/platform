package com.platform.repository;

import com.platform.entity.quartz.JobDetailKey;
import com.platform.entity.quartz.QuartzJobDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobDetailRepository extends JpaRepository<QuartzJobDetails, JobDetailKey> {



}
