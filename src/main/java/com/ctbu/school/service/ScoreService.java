package com.ctbu.school.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ctbu.school.mapper.ParentMapper;
import com.ctbu.school.mapper.ScoreMapper;
import com.ctbu.school.model.Parent;
import com.ctbu.school.model.Score;
import org.springframework.stereotype.Service;

@Service
public class ScoreService  extends ServiceImpl<ScoreMapper, Score> implements IService<Score> {
}
