package com.ctbu.school.dto;

import lombok.Data;

@Data
public class GradeDto {
    long total;
    long rank;
    long increase;
    int[] count=new int[10];
}
