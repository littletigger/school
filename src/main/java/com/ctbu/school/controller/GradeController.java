package com.ctbu.school.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ctbu.school.dto.GradeDto;

import com.ctbu.school.model.Grade;
import com.ctbu.school.model.ScoreAnaly;
import com.ctbu.school.model.Student;
import com.ctbu.school.service.GradeService;
import com.ctbu.school.service.ScoreAnalyService;
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
    @Autowired
    ScoreAnalyService scoreAnalyService;
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
    public GradeDto analy(@RequestParam("examId")long examId){
        int[] count=new int[10];
        QueryWrapper<ScoreAnaly> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("exam_id",examId);
       ScoreAnaly scoreAnaly=scoreAnalyService.getOne(queryWrapper);
         queryWrapper.between("total",0,200);
         count[0]=scoreAnalyService.count(queryWrapper);
         queryWrapper.clear();
         queryWrapper.eq("exam_id",examId).between("total",200,300);
         count[1]=scoreAnalyService.count(queryWrapper);
        queryWrapper.clear();
        queryWrapper.eq("exam_id",examId).between("total",300,400);
        count[2]=scoreAnalyService.count(queryWrapper);
        queryWrapper.clear();
        queryWrapper.eq("exam_id",examId).between("total",400,500);
        count[3]=scoreAnalyService.count(queryWrapper);
        queryWrapper.clear();
        queryWrapper.eq("exam_id",examId).between("total",500,1000);
        count[4]=scoreAnalyService.count(queryWrapper);
        GradeDto gradeDto=new GradeDto();

        gradeDto.setCount(count);
        gradeDto.setIncrease(scoreAnaly.getRaise());
        gradeDto.setRank(scoreAnaly.getRank());
        gradeDto.setTotal(scoreAnaly.getTotal());

        return gradeDto;

    }

    @GetMapping("/scanaly")
    @ResponseBody
    public  List<ScoreAnaly> scanaly(@RequestParam("studentId")long studentId){
        QueryWrapper<ScoreAnaly> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("student_id",studentId).orderByAsc("exam_id");

        return  scoreAnalyService.list(queryWrapper);



    }




}
