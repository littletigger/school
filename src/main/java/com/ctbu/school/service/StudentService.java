package com.ctbu.school.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ctbu.school.mapper.InformMapper;
import com.ctbu.school.mapper.StudentMapper;
import com.ctbu.school.model.Inform;
import com.ctbu.school.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends ServiceImpl<StudentMapper, Student> implements IService<Student> {
}
