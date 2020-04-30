package com.ctbu.school.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ctbu.school.mapper.ParentMapper;
import com.ctbu.school.mapper.ScoreAnalyMapper;
import com.ctbu.school.model.Parent;
import com.ctbu.school.model.ScoreAnaly;
import org.springframework.stereotype.Service;

@Service
public class ScoreAnalyService extends ServiceImpl<ScoreAnalyMapper, ScoreAnaly> implements IService<ScoreAnaly> {
}
