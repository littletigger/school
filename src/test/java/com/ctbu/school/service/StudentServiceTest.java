package com.ctbu.school.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ctbu.school.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    StudentService studentService;
    @Test
    public void getOne() {
        SimpleDateFormat format=new SimpleDateFormat("MM-dd HH:mm:ss E");
        String time=format.format(new Date());
        System.out.println("当前时间: "+time);



    }
}