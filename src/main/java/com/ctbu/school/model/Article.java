package com.ctbu.school.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ctbu.school.utils.TimeUtil;
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
    String time= TimeUtil.formatDate();
    long classId;



}
