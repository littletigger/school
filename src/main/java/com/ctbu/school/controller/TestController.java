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
import org.springframework.web.bind.annotation.*;

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



    //查找对应班级下的班级圈
    @GetMapping("/index")
    @ResponseBody
    public List<IndexDto> index(@RequestParam("classId")long classId){
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Article> queryWrapperAticle = new QueryWrapper<>();
        queryWrapperAticle.eq("class_id",classId);
        List<IndexDto>indexDtos=new ArrayList<>();
        //System.err.println( articleService.list());
        //封装数据，将每篇文章的评论与文章封装到一起传输到前端
        for (Article a:articleService.list(queryWrapperAticle)
             ) {
            queryWrapper.eq("article_id",a.getId());
           indexDtos.add(new IndexDto(a,commentService.list(queryWrapper)));

        }
      return  indexDtos;

    }

}
