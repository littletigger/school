package com.ctbu.school.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ctbu.school.mapper.TeacherMapper;
import com.ctbu.school.mapper.WorkMapper;
import com.ctbu.school.model.Teacher;
import com.ctbu.school.model.Work;
import org.springframework.stereotype.Service;

@Service
public class TeacherService extends ServiceImpl<TeacherMapper, Teacher> implements IService<Teacher> {
}
