package com.ctbu.school.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ctbu.school.dto.IndexDto;
import com.ctbu.school.model.Article;
import com.ctbu.school.model.Comment;
import com.ctbu.school.service.ArticleService;
import com.ctbu.school.service.CommentService;
import com.ctbu.school.service.TestService;
import org.nutz.dao.entity.annotation.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;
    @PostMapping("/test")
    @ResponseBody
    public void   test(){
        com.ctbu.school.model.Test test=new com.ctbu.school.model.Test();
        test.setId(1);
        System.out.print(test);
        //testService.save(test);
    }
    @GetMapping("/index")
    @ResponseBody
    public List<IndexDto> index(){
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();

        List<IndexDto>indexDtos=new ArrayList<>();
        //System.err.println( articleService.list());
        for (Article a:articleService.list()
             ) {
            queryWrapper.eq("article_id",a.getId());
           indexDtos.add(new IndexDto(a,commentService.list(queryWrapper)));

        }
      return  indexDtos;

    }

}
