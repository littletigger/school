package com.ctbu.school.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("work")
@Data
public class Work extends BaseEntity {
    long userId;
    String user;
    String course;
    String content;
    Date endTime;
    long classId;
    String state;
    String image;

}
