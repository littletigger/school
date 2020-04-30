package com.ctbu.school.controller;

import com.ctbu.school.service.ExcelRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ExcleController {
    @Autowired
    private ExcelRead excelRead;

    /**
     * 成绩上传
     * @param file
     * @param classId
     * @return
     */
    @PostMapping("/uploadExcel")
    @ResponseBody
    public String uploadExcel(@RequestParam(value="file") MultipartFile file,@RequestParam("classId")long classId){
       // long classId=1;
        String result =  excelRead.readExcelFile(file,classId);
        return result;
    }
}
