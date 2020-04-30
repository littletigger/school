package com.ctbu.school.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class Score {
   String name;
   long math;
   long engilsh;
   long chinese;
    long english;
    long physics;
    long chemistry;
    long sport;
    long biology;
    long total;
    long termId;
    long studentId;
     String examName;
     long examId;
     long rank;




}
