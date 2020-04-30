package com.ctbu.school.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("exam")
public class Exam {
    long id;
    String examName;
    long classId;
    long average;
}
