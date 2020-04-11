package com.ctbu.school.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ctbu.school.mapper.ArticleMapper;
import com.ctbu.school.mapper.CommentMapper;
import com.ctbu.school.model.Article;
import com.ctbu.school.model.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends ServiceImpl<CommentMapper, Comment> implements IService<Comment> {
}
