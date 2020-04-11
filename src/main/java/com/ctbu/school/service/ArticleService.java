package com.ctbu.school.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ctbu.school.mapper.ArticleMapper;
import com.ctbu.school.mapper.TestMapper;
import com.ctbu.school.model.Article;
import com.ctbu.school.model.Test;
import org.springframework.stereotype.Service;

@Service
public class ArticleService extends ServiceImpl<ArticleMapper, Article> implements IService<Article> {
}
