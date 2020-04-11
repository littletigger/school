package com.ctbu.school.controller;

import com.ctbu.school.model.Inform;
import com.ctbu.school.service.InformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class InformController {
    @Autowired
    InformService informService;

    @GetMapping("/inform")
    @ResponseBody
    public List<Inform> inform(){
        System.err.println(informService.list());
      return informService.list();
    }

    @GetMapping("/inform/detail")
    @ResponseBody
    public List<Inform> detail(@RequestParam("id")long id){


        System.err.println(informService.list());
        return informService.list();
    }

}
