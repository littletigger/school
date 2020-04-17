package com.ctbu.school.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ctbu.school.model.Article;
import com.ctbu.school.model.Grade;
import com.ctbu.school.service.ArticleService;
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
    @PostMapping("/push")
    @ResponseBody
    public Result pushArticle(@RequestParam("file") MultipartFile uploadFile){

        System.err.println(uploadFile.getOriginalFilename());
        uploadFile.getOriginalFilename();
        return  Result.success("success");

    }

}
