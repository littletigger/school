package com.ctbu.school.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@TableName("student")
@Data
public class Student extends BaseEntity {
    String name;
    String phone;
    String password;
    String avatar;
    long classId;
}
