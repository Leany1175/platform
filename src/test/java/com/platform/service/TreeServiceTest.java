package com.platform.service;

import com.alibaba.fastjson.JSON;
import com.platform.PlatformApplication;
import com.platform.entity.TreeBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PlatformApplication.class)
public class TreeServiceTest {

    @Autowired
    private TreeService treeService;

    @Test
    public void rootTest() {
        TreeBean treeBean = treeService.root();
        System.out.println(JSON.toJSONString(treeBean, true));
    }

}
