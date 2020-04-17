package com.ctbu.school.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ctbu.school.dto.StuParentDto;
import com.ctbu.school.model.Comment;
import com.ctbu.school.model.Inform;
import com.ctbu.school.model.Parent;
import com.ctbu.school.model.Student;
import com.ctbu.school.service.ParentService;
import com.ctbu.school.service.Stu_parentService;
import com.ctbu.school.service.StudentService;
import com.ctbu.school.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.awt.X11.XSystemTrayPeer;

import java.util.List;


@Controller
public class LoginController {

    @Autowired
    StudentService studentService;
    @Autowired
    ParentService parentService;
    @Autowired
    Stu_parentService stu_parentService;

    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestParam("user")String user,@RequestParam("password")String password,@RequestParam("radio")String radio){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();

        if(radio.equals("1")){
            queryWrapper.eq("phone",user);
           Student student=studentService.getOne(queryWrapper);
           System.err.println(student);
            StuParentDto stuParentDto=new StuParentDto();
            stuParentDto.setStudent(student);
           if(student!=null)
           return Result.success(stuParentDto);

        }else if(radio.equals("2")){
            QueryWrapper<Parent> queryWrappertwo = new QueryWrapper<>();
            queryWrappertwo.eq("phone",user);
            Parent parent=parentService.getOne(queryWrappertwo);
            StuParentDto stuParentDto=new StuParentDto();
            stuParentDto.setParent(parent);
            Student student=null;
            if(parent!=null){
            student= studentService.getById( stu_parentService.getById(parent.getId()).getStudentId());
            stuParentDto.setStudent(student);
            System.err.println(stuParentDto);
            }
            if(parent!=null&student!=null)
            return Result.success(stuParentDto);
        }
        return Result.error(0,"用户不存在！");

    }

}
