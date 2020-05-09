package com.ctbu.school.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ctbu.school.dto.InformDto;
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
    public List<InformDto> inform(@RequestParam("classId")long classId){
        QueryWrapper<Inform> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("class_id",classId);
        System.err.println(informService.list(queryWrapper));
        List<InformDto> informDtoList=new ArrayList<>();
        for (Inform inform:informService.list(queryWrapper)
             ) {
            InformDto informDto=new InformDto(inform);
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

        List<TeacherClass> teacherClasses=teacherClassService.list(queryWrapper);
        for (TeacherClass t:teacherClasses
             ) {
            informQueryWrapper.eq("class_id",t.getClassId());
            for (Inform inform:informService.list(informQueryWrapper)
            ) {
                InformDto informDto=new InformDto(inform);
                informDtoList.add(informDto);

            }
        }



        return  informDtoList;
    }
}
