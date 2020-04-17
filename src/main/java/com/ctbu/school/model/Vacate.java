package com.ctbu.school.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("vacate")
@Data
public class Vacate extends BaseEntity {
    String beginTime;
    String endTime;
    String content;
    long classId;
    long teacherId;
    String state="待审核";

}
