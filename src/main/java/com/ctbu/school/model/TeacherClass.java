package com.ctbu.school.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;

@TableName("teacher_class")
@Data
public class TeacherClass extends BaseEntity {
    long teacherid;
    long classid;
     byte manager;

}
