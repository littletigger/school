package com.ctbu.school.dto;

import com.ctbu.school.model.Parent;
import com.ctbu.school.model.Student;
import lombok.Data;

@Data
public class StuParentDto {
    Student student;
    Parent parent;
}
