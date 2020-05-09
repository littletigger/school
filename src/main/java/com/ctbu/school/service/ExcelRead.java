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

    public String readExcelFile(MultipartFile file,long classId) {
        String result = "";
        ExcelUtil excel = new ExcelUtil();
        List<Score> ilist = excel.getExcelInfo(file);

        if (ilist != null && !ilist.isEmpty()) {
            //不为空的话添加到数据库
            Exam exam=new Exam();
            QueryWrapper<Exam> queryWrapper=new QueryWrapper();
            QueryWrapper<Student> queryWrapperStu=new QueryWrapper();
            queryWrapperStu.eq("class_id",classId);
            exam.setAverage(getAverage(ilist));
            exam.setExamName(ilist.get(0).getExamName());
            exam.setClassId(classId);
            examService.save(exam);
            queryWrapper.eq("exam_name",exam.getExamName());

            Exam exam1=examService.getOne(queryWrapper);
            long examId=exam1.getId();
            List<Student>students=studentService.list(queryWrapperStu);
            for (Score score : ilist) {
                for(Student student:students){
                    if(student.getName().equals(score.getName())){
                        Grade grade=new Grade();
                        grade.setExamId(examId);
                        grade.setStudentId(student.getId());
                        grade.setEnglish(score.getEnglish());
                        grade.setChinese(score.getChinese());
                        grade.setMath(score.getMath());
                        grade.setBiology(score.getBiology());
                        grade.setPhysics(score.getPhysics());
                        grade.setChemistry(score.getChemistry());
                        grade.setExamName(exam1.getExamName());
                        gradeService.save(grade);
                        ScoreAnaly scoreAnaly=new ScoreAnaly();
                        scoreAnaly.setExamId(examId);
                        scoreAnaly.setStudentId(student.getClassId());
                        scoreAnaly.setRank(score.getRank());
                        scoreAnaly.setTotal(score.getTotal());
                        scoreAnaly.setAverage(exam.getAverage());
                        scoreAnaly.setRaise(getRaise(classId,student.getId(),score.getRank()));
                        scoreAnalyService.save(scoreAnaly);

                    }
                }
                //System.err.println(score);

            }
            result = "上传成功";
        } else {
            result = "上传失败";
        }
        return result;
    }

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
