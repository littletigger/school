package com.ctbu.school.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ctbu.school.mapper.Stu_parentMapper;
import com.ctbu.school.mapper.StudentMapper;
import com.ctbu.school.model.Stu_parent;
import com.ctbu.school.model.Student;
import org.springframework.stereotype.Service;

@Service
public class Stu_parentService extends ServiceImpl<Stu_parentMapper, Stu_parent> implements IService<Stu_parent> {
}
