package com.ctbu.school.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ctbu.school.mapper.ClassMapper;
import com.ctbu.school.mapper.ExamMapper;
import com.ctbu.school.model.Class;
import com.ctbu.school.model.Exam;
import org.springframework.stereotype.Service;

@Service
public class ClassService extends ServiceImpl<ClassMapper, Class> implements IService<Class> {

}
