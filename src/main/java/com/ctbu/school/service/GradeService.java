package com.ctbu.school.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ctbu.school.mapper.GradeMapper;
import com.ctbu.school.mapper.VacateMapper;
import com.ctbu.school.model.Grade;
import com.ctbu.school.model.Vacate;
import org.springframework.stereotype.Service;

@Service
public class GradeService extends ServiceImpl<GradeMapper, Grade> implements IService<Grade> {
}
