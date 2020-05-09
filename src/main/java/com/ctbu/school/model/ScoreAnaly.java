package com.ctbu.school.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("score_analy")
public class ScoreAnaly {
    long id;
    long examId;
    long rank;
    long studentId;
    long total;
    long raise;
    long average;
}
