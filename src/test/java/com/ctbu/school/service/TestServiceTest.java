package com.ctbu.school.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class TestServiceTest {
    @Autowired
    private  TestService testService;
    @Autowired
    private ArticleService articleService;
    @Test
    void test1() {
        com.ctbu.school.model.Test test=new com.ctbu.school.model.Test();
        test.setId(1);
        System.out.print(test);
        testService.save(test);
    }
    @Test
    void index() {

        System.out.print(articleService.list());
    }
}