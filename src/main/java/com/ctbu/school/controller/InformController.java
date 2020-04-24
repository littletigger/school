package com.ctbu.school.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ctbu.school.model.Comment;
import com.ctbu.school.model.Inform;
import com.ctbu.school.model.TeacherClass;
import com.ctbu.school.service.InformService;
import com.ctbu.school.service.TeacherClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InformController {
    @Autowired
    InformService informService;
    @Autowired
    TeacherClassService teacherClassService;


    @GetMapping("/inform")
    @ResponseBody
    public List<Inform> inform(@RequestParam("classId")long classId){
        QueryWrapper<Inform> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("class_id",classId);
        System.err.println(informService.list(queryWrapper));
      return informService.list(queryWrapper);
    }

    @GetMapping("/inform/detail")
    @ResponseBody
    public List<Inform> detail(@RequestParam("id")long id){


        System.err.println(informService.list());
        return informService.list();
    }


    @GetMapping("/tinform")
    @ResponseBody
    public List<Inform>tinform(@RequestParam("teacherId")long id){
        List<Long> classIds=new ArrayList<>();
         QueryWrapper<TeacherClass> queryWrapper=new QueryWrapper<>();
         queryWrapper.eq("teacher_id",id);
        QueryWrapper<Inform> queryWrapperinform=new QueryWrapper<>();
        List<TeacherClass> teacherClasses=teacherClassService.list(queryWrapper);
        for (TeacherClass t:teacherClasses
             ) {
            classIds.add(t.getClassid());
        }


        System.err.println(informService.listByIds(classIds));
        return informService.listByIds(classIds);
    }
}
