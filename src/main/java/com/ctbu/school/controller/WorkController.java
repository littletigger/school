package com.ctbu.school.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ctbu.school.model.Inform;
import com.ctbu.school.model.Student;
import com.ctbu.school.model.Work;
import com.ctbu.school.service.WorkService;
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
    @GetMapping("/work")
    @ResponseBody
    public List<Work> homeWorke(@RequestParam("classId")long classId){
        Date date=new Date();
        QueryWrapper<Work> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("class_id",classId);
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
