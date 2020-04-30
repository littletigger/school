package com.ctbu.school.model;

import lombok.Data;

@Data
public class ReadExcel {
    //总行数
    private int totalRows = 0;

    //总条数
    private int totalCells = 0;

    //错误信息的收集类
    private String errorMsg;

}
