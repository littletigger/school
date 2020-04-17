package com.ctbu.school.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("schedule")
@Data
public class Schedule extends BaseEntity {
    long classId;
    long day;

}
