package com.ctbu.school.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("inform")
@Data
public class Inform  extends  BaseEntity{
     String title;
     String content;
     String author;
     String imageUrl;
     long classId;

}
