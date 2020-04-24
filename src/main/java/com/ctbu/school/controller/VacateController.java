package com.ctbu.school.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ctbu.school.model.Inform;
import com.ctbu.school.model.Teacher;
import com.ctbu.school.model.TeacherClass;
import com.ctbu.school.model.Vacate;
import com.ctbu.school.service.TeacherClassService;
import com.ctbu.school.service.TeacherService;
import com.ctbu.school.service.VacateService;
import com.ctbu.school.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VacateController {
    @Autowired
    VacateService vacateService;
    @Autowired
    TeacherClassService teacherClassService;
    @PostMapping("/vacate")
    @ResponseBody
    public Result vacate(@RequestBody Vacate vacate){
        QueryWrapper<TeacherClass> queryWrapper=new QueryWrapper();
        queryWrapper.eq("class_id",vacate.getClassId()).eq("manager",1);
        System.err.println(vacate);

        TeacherClass teacherClass=teacherClassService.getOne(queryWrapper);
        if (teacherClass!=null){
            vacate.setTeacherId(teacherClass.getTeacherid());
            vacateService.save(vacate);
            return Result.success("提交成功");
        }
        return Result.error(0,"找不到老师");

    }

    @GetMapping("/vaList")
    @ResponseBody
    public Result vaList(@RequestParam("teacherId")long teacherId ){
        QueryWrapper<Vacate> queryWrapper=new QueryWrapper();
        queryWrapper.eq("teacher_id",teacherId);

        return  Result.success(vacateService.list(queryWrapper));

    }
    @GetMapping("/vaDetail")
    @ResponseBody
    public Result vaDetail(@RequestParam("id")long id){


        return  Result.success(vacateService.getById(id));

    }
    @PostMapping("/examin")
    @ResponseBody
    public Result examin(@RequestBody Vacate vacate){
        System.err.println(vacate);
        UpdateWrapper<Vacate> updateWrapper=new UpdateWrapper<>();
        updateWrapper.set("comment",vacate.getComment()).set("state","通过").eq("id",vacate.getId());
        vacateService.update(vacate,updateWrapper);

        return  Result.success("success");

    }
}
