package com.platform.quartz.service;

import com.platform.PlatformApplication;
import com.platform.quartz.entity.QuartzJobDetails;
import com.platform.utils.layui.LayuiEntity;
import com.platform.utils.layui.Table;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PlatformApplication.class)
public class JobDetaiServiceTest {

    @Autowired
    private JobDetaiService jobDetaiService;

    @Test
    public void findPageTest() {
        LayuiEntity<QuartzJobDetails> entity = jobDetaiService.findPage(new Table(1, 10));
        System.out.println(entity);
    }

}
