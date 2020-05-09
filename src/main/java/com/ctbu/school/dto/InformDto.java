package com.ctbu.school.dto;

import com.ctbu.school.model.Inform;
import com.ctbu.school.utils.TimeUtil;
import lombok.Data;

import java.util.Date;

@Data
public class InformDto {
    long id;
    Date createTime;
    String title;
    String content;
    String author;
    String imageUrl;
    long classId;
    String time;

    public InformDto(Inform inform) {
        this.id=inform.getId();
        this.createTime=inform.getCreateTime();
        this.classId=inform.getClassId();
        this.author=inform.getAuthor();
        this.content=inform.getContent();
        this.imageUrl=inform.getImageUrl();
        this.title=inform.getTitle();
        this.time= TimeUtil.formatDate(this.createTime);
    }
}
