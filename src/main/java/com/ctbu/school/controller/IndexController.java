package com.ctbu.school.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ctbu.school.model.Article;
import com.ctbu.school.model.Comment;
import com.ctbu.school.model.Grade;
import com.ctbu.school.model.Vacate;
import com.ctbu.school.service.ArticleService;
import com.ctbu.school.service.CommentService;
import com.ctbu.school.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    ArticleService articleService;
    @Autowired
    CommentService commentService;


    @PostMapping("/push")
    @ResponseBody
    public Result pushArticle(@RequestParam("file") MultipartFile uploadFile){

        System.err.println(uploadFile.getOriginalFilename());
        uploadFile.getOriginalFilename();
        return  Result.success("success");

    }
    //点赞功能实现
    @PostMapping("/dz")
    @ResponseBody
    public Result dz(@RequestParam("id") long id,@RequestParam("count") long count){

        UpdateWrapper<Article> updateWrapper=new UpdateWrapper<>();
        updateWrapper.set("count",count).eq("id",id);
        articleService.update(updateWrapper);

        return  Result.success("success");

    }


    //评论功能实现
    @PostMapping("/comment")
    @ResponseBody
    public Result dz(@RequestParam("id") long id,@RequestParam("comment") String comment,@RequestParam("name") String name){

        Comment comment1=new Comment();
        comment1.setArticleId(id);
        comment1.setComment(comment);
        comment1.setUser(name);

        commentService.save(comment1);

        return  Result.success("success");

    }
}
