package com.ctbu.school.controller;

import com.ctbu.school.model.Inform;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LoginController {

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam("user")String user,@RequestParam("password")String password,@RequestParam("radio")String radio){

        return user;

    }

}
