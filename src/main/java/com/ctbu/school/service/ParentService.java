package com.ctbu.school.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ctbu.school.mapper.InformMapper;
import com.ctbu.school.mapper.ParentMapper;
import com.ctbu.school.model.Inform;
import com.ctbu.school.model.Parent;
import org.springframework.stereotype.Service;

@Service
public class ParentService  extends ServiceImpl<ParentMapper, Parent> implements IService<Parent> {
}
