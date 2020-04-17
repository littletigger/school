package com.ctbu.school.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("teacher")
@Data
public class Teacher extends BaseEntity{
    String name;
    String phone;
    String password;
    String avatar;


}
