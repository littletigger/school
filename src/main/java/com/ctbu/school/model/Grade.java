package com.ctbu.school.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("grade")
@Data
public class Grade extends BaseEntity {
    long studentId;
    long term;
    String name;
    long math;
    long chinese;
    long english;
    long physics;
    long chemistry;
    long sport;
    long biology;

}
