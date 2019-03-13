package com.platform.quartz.service.impl;

import com.platform.quartz.entity.QuartzJobDetails;
import com.platform.quartz.repository.JobDetailRepository;
import com.platform.quartz.service.JobDetaiService;
import com.platform.utils.layui.LayuiEntity;
import com.platform.utils.layui.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class JobDetaiServiceImpl implements JobDetaiService {

    private static Logger logger = LoggerFactory.getLogger(JobDetaiServiceImpl.class);

    @Autowired
    private JobDetailRepository jobDetailRepository;

    @Override
    public LayuiEntity<QuartzJobDetails> findPage(Table table) {
        logger.info("任务详情分页查询:{}", table);
        // 分页查询
        Page<QuartzJobDetails> page = jobDetailRepository.findAll(new PageRequest(table.getPage() - 1, table.getLimit()));
        LayuiEntity<QuartzJobDetails> entity = new LayuiEntity<>(page.getTotalElements(), page.getContent());
        logger.info("任务详情分页查询结果:{}", table);
        return entity;
    }

}
