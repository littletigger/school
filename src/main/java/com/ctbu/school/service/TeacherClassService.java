package com.ctbu.school.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ctbu.school.mapper.TeacherClassMapper;
import com.ctbu.school.mapper.TeacherMapper;
import com.ctbu.school.model.Teacher;
import com.ctbu.school.model.TeacherClass;
import org.springframework.stereotype.Service;

@Service
public class TeacherClassService extends ServiceImpl<TeacherClassMapper, TeacherClass> implements IService<TeacherClass> {
}
