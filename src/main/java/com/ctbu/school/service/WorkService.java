package com.ctbu.school.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ctbu.school.mapper.WorkMapper;
import com.ctbu.school.model.Work;
import org.springframework.stereotype.Service;

@Service
public class WorkService extends ServiceImpl<WorkMapper, Work> implements IService<Work> {
}
