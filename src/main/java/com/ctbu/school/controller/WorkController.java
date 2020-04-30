package com.ctbu.school.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ctbu.school.model.Inform;
import com.ctbu.school.model.Student;
import com.ctbu.school.model.Work;
import com.ctbu.school.service.WorkService;
import com.ctbu.school.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class WorkController {
    @Autowired
    WorkService workService;

    //查询对应班级下的家庭作业
    @GetMapping("/work")
    @ResponseBody
    public List<Work> homeWork(@RequestParam("classId")long classId){
        Date date=new Date();
        QueryWrapper<Work> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("class_id",classId).orderByDesc("end_time");
       ;
       List<Work>workList= workService.list(queryWrapper);
       //根据截止时间修改当前作业状态
        for (Work w: workList
             ) {
            if (date.before(w.getEndTime())){
                w.setState("进行中");
            }else {
                w.setState("已截止");
            }
            w.setTime(TimeUtil.formatDate(w.getCreateTime()));
        }
        System.err.println(workList);
        return workList ;
    }

    @GetMapping("/twork")
    @ResponseBody
    public List<Work> ThomeWork(@RequestParam("teacherId")long teacherId){
        Date date=new Date();
        QueryWrapper<Work> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("teacher_id",teacherId);
        ;
        List<Work>workList= workService.list(queryWrapper);
        for (Work w: workList
        ) {
            if (date.before(w.getEndTime())){
                w.setState("进行中");
            }else {
                w.setState("已截止");
            }

        }
        System.err.println(workList);
        return workList ;
    }
}
