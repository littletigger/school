package com.ctbu.school.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ctbu.school.mapper.ExamMapper;
import com.ctbu.school.mapper.GradeMapper;
import com.ctbu.school.model.Exam;
import com.ctbu.school.model.Grade;
import org.springframework.stereotype.Service;

@Service
public class ExamService extends ServiceImpl<ExamMapper, Exam> implements IService<Exam> {
}
