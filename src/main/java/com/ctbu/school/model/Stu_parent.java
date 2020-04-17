package com.ctbu.school.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("student_parent")
@Data
public class Stu_parent extends BaseEntity {
    long parentId;
    long studentId;

}
