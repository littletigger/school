package com.ctbu.school.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@TableName("parent")
@Data
public class Parent  extends BaseEntity{
    String name;
    String phone;
    String password;
    String avatar;

}
