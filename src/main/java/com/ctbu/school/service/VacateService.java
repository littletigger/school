package com.ctbu.school.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ctbu.school.mapper.VacateMapper;
import com.ctbu.school.mapper.WorkMapper;
import com.ctbu.school.model.Vacate;
import com.ctbu.school.model.Work;
import org.springframework.stereotype.Service;

@Service
public class VacateService extends ServiceImpl<VacateMapper, Vacate> implements IService<Vacate> {
}
