package com.platform.repository;

import com.platform.entity.quartz.QuartzBlobTriggers;
import com.platform.entity.quartz.TriggersKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlobTriggers extends JpaRepository<QuartzBlobTriggers, TriggersKey> {



}
