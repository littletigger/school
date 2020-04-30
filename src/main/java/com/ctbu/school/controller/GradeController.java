package com.ctbu.school.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ctbu.school.dto.GradeDto;
import com.ctbu.school.model.Grade;
import com.ctbu.school.model.Student;
import com.ctbu.school.service.GradeService;
import com.ctbu.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GradeController {
    @Autowired
    GradeService gradeService;
    @Autowired
    StudentService studentService;
    //根据学生id获取考试列表
    @GetMapping("/gradeList")
    @ResponseBody
    public List<Grade> gradeList(@RequestParam("studentId")long studentId){
        QueryWrapper<Grade> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_id",studentId);
       // System.err.println(gradeService.list(queryWrapper));
        return  gradeService.list(queryWrapper);

    }
    //根据考试编号获取成绩
    @GetMapping("/grade")
    @ResponseBody
    public Grade grade(@RequestParam("id")long id){
        Grade grade=gradeService.getById(id);

       System.err.println(grade);
        return grade;

    }
    @GetMapping("/analy")
    @ResponseBody
    public GradeDto analy(){
        GradeDto gradeDto=new GradeDto();
        int[] count=new int[10];
        count[0]=20;
        count[1]=10;
        count[2]=15;
        count[3]=6;
        count[4]=8;
        gradeDto.setCount(count);
        gradeDto.setIncrease(10);
        gradeDto.setRank(3);
        gradeDto.setTotal(300);

        return gradeDto;

    }




}
