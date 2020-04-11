package com.ctbu.school.model;

import lombok.Data;

import java.util.Date;
@Data
public class BaseEntity {
    long id;
    Date createTime=new Date();
}
