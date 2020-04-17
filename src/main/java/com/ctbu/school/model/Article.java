package com.ctbu.school.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("article")
@Data
public class Article extends  BaseEntity{

    String user;
    String content;
    String comment;
    String imageUrl;
    int count;

    long classId;



}
