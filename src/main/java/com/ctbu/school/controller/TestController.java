package com.ctbu.school.controller;

import com.ctbu.school.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    private TestService testService;
    @PostMapping("/test")
    @ResponseBody
    public void   test(){
        com.ctbu.school.model.Test test=new com.ctbu.school.model.Test();
        test.setId(1);
        System.out.print(test);
        //testService.save(test);


    }
}
