package com.platform.repository;

import com.platform.PlatformApplication;
import com.platform.quartz.entity.QuartzJobDetails;
import com.platform.quartz.repository.JobDetailRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PlatformApplication.class)
public class JobDetailRepositoryTest {

    @Autowired
    private JobDetailRepository jobDetailRepository;

    @Test
    public void findAllTest() {
        List<QuartzJobDetails> list = jobDetailRepository.findAll();
        list.forEach(System.out :: println);
        System.out.println("finish");
    }


}