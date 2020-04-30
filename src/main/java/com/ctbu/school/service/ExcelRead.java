package com.ctbu.school.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ctbu.school.model.*;
import com.ctbu.school.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Service
public class ExcelRead {
    @Autowired
    ExamService examService;
    @Autowired
    StudentService studentService;
    @Autowired
    GradeService gradeService;
    @Autowired
    ScoreAnalyService scoreAnalyService;
   
    //计算班级平均分
    public long  getAverage(List<Score>scoreList){
        long average=0;
        long t=0;
        int count=0;
        if ((scoreList!=null&&!scoreList.isEmpty())){
            for (Score score : scoreList) {
              t=t+score.getTotal();
              count++;
            }
            average=t/count;

        }

        return  average;
    }
    //计算进步名次
    public long getRaise(long classId,long studentId,long rank){
        QueryWrapper<Exam> queryWrapper=new QueryWrapper();
        queryWrapper.eq("class_id",classId);
        QueryWrapper<ScoreAnaly> queryWrapperGra=new QueryWrapper<>();
       List<Exam>exams= examService.list(queryWrapper);
       if(exams.size()>1) {
           long beforeExamId = exams.get(exams.size() - 2).getId();
           long nowExamId = exams.get(exams.size() - 1).getId();
           queryWrapperGra.eq("exam_id", beforeExamId).eq("student_id", studentId);
           ScoreAnaly scoreAnaly = scoreAnalyService.getOne(queryWrapperGra);

          // queryWrapperGra.clear();
          // queryWrapperGra.eq("exam_id", nowExamId).eq("student_id", studentId);
          // ScoreAnaly scoreAnaly1 = scoreAnalyService.getOne(queryWrapperGra);
           long raise = scoreAnaly.getRank()-rank;
           return raise;
       }else {
           return 0;
       }


    }


}
