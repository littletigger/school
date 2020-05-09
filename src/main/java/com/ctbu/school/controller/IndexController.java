package com.ctbu.school.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ctbu.school.dto.IndexDto;
import com.ctbu.school.model.*;
import com.ctbu.school.service.ArticleService;
import com.ctbu.school.service.CommentService;
import com.ctbu.school.service.TeacherClassService;
import com.ctbu.school.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    ArticleService articleService;
    @Autowired
    CommentService commentService;

    @Autowired
    TeacherClassService teacherClassService;


    //查找对应班级下的班级圈
    @GetMapping("/tindex")
    @ResponseBody
    public List<IndexDto> index(@RequestParam("teacherId")long teacherId){
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Article> queryWrapperAticle = new QueryWrapper<>();
        QueryWrapper<TeacherClass>teacherClassQueryWrapper=new QueryWrapper<>();
        teacherClassQueryWrapper.eq("teacher_id",teacherId);
        List<TeacherClass>teacherClassList=teacherClassService.list(teacherClassQueryWrapper);
        List<IndexDto>indexDtos=new ArrayList<>();
        for (TeacherClass t:teacherClassList
             ) {
            queryWrapperAticle.eq("class_id",t.getClassId());

            //System.err.println( articleService.list());
            //封装数据，将每篇文章的评论与文章封装到一起传输到前端
            for (Article a:articleService.list(queryWrapperAticle)
            ) {
                queryWrapper.eq("article_id",a.getId());
                indexDtos.add(new IndexDto(a,commentService.list(queryWrapper)));

            }
        }



        return  indexDtos;

    }
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
