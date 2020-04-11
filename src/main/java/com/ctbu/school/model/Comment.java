package com.ctbu.school.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("comment")
@Data
public class Comment extends  BaseEntity {

    long articleId;
    String user;
    String comment;

}
