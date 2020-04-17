package com.ctbu.school.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ctbu.school.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    StudentService studentService;
    @Test
    public void getOne() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();

            queryWrapper.eq("phone","17784456304");
            Student student=studentService.getOne(queryWrapper);
            System.err.println(student);



    }
}