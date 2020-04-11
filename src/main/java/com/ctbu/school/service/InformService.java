package com.ctbu.school.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ctbu.school.mapper.ArticleMapper;
import com.ctbu.school.mapper.InformMapper;
import com.ctbu.school.model.Article;
import com.ctbu.school.model.Inform;
import org.springframework.stereotype.Service;

@Service
public class InformService extends ServiceImpl<InformMapper,Inform> implements IService<Inform> {
}
