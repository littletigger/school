package com.ctbu.school.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ctbu.school.dto.InformDto;
import com.ctbu.school.dto.PushInformDto;
import com.ctbu.school.model.Class;
import com.ctbu.school.model.Comment;
import com.ctbu.school.model.Inform;
import com.ctbu.school.model.TeacherClass;
import com.ctbu.school.service.ClassService;
import com.ctbu.school.service.InformService;
import com.ctbu.school.service.TeacherClassService;
import com.ctbu.school.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.Line;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class InformController {
    @Autowired
    InformService informService;
    @Autowired
    TeacherClassService teacherClassService;
    @Autowired
    ClassService classService;

    @PostMapping("/pushInform")
    @ResponseBody
    public Result pushInform(@RequestBody PushInformDto pushInformDto){
        System.out.println(pushInformDto);
        Date date=new Date();

        for (Long classId:pushInformDto.getClassIdList()){
            Inform inform=new Inform();
            inform.setAuthor(pushInformDto.getAuthor());
            inform.setContent(pushInformDto.getContent());
            inform.setImageUrl(pushInformDto.getImageUrl());
            inform.setTitle(pushInformDto.getTitle());
            inform.setClassId(classId);
            inform.setCreateTime(date);
            informService.save(inform);
        }
        return Result.success("success");
    }

    @GetMapping("/inform")
    @ResponseBody
    public List<InformDto> inform(@RequestParam("classId")long classId){
        QueryWrapper<Inform> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("class_id",classId);
        System.err.println(informService.list(queryWrapper));
        List<InformDto> informDtoList=new ArrayList<>();
        for (Inform inform:informService.list(queryWrapper)
             ) {
            InformDto informDto=new InformDto(inform,"tt");
            informDtoList.add(informDto);

        }


      return informDtoList;
    }

    @GetMapping("/inform/detail")
    @ResponseBody
    public List<Inform> detail(@RequestParam("id")long id){


        System.err.println(informService.list());
        return informService.list();
    }


    @GetMapping("/tinform")
    @ResponseBody
    public List<InformDto>tinform(@RequestParam("teacherId")long id){
        List<InformDto> informDtoList=new ArrayList<>();
         QueryWrapper<TeacherClass> queryWrapper=new QueryWrapper<>();
         queryWrapper.eq("teacher_id",id);
        QueryWrapper<Inform> informQueryWrapper = new QueryWrapper<>();
        QueryWrapper<Class>classQueryWrapper=new QueryWrapper<>();

        List<TeacherClass> teacherClasses=teacherClassService.list(queryWrapper);
        for (TeacherClass t:teacherClasses
             ) {
            informQueryWrapper.clear();
            informQueryWrapper.eq("class_id",t.getClassId());
            classQueryWrapper.clear();
            classQueryWrapper.eq("id",t.getClassId());
            Class c=classService.getOne(classQueryWrapper);
            String className=c.getClassName();
            for (Inform inform:informService.list(informQueryWrapper)
            ) {
                InformDto informDto=new InformDto(inform,className);
                //System.out.println(informDto);
                informDtoList.add(informDto);

            }
        }



        return  informDtoList;
    }
    @GetMapping("/tinform/delete")
    @ResponseBody
    public  Result delteInform(@RequestParam("deleteId")long id){
        QueryWrapper<Inform> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",id);
        informService.remove(queryWrapper);

        return  Result.success("success");

    }
}
