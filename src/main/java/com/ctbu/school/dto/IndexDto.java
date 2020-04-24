package com.ctbu.school.dto;

import com.ctbu.school.model.Article;
import com.ctbu.school.model.Comment;
import com.ctbu.school.utils.TimeUtil;
import lombok.Data;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
public class IndexDto {
    Date createTime;
    List<Comment>comment ;
    String user;
    String content;
    String imageUrl;
    int count;
    long id;
    String time;

    public IndexDto(Article article, List<Comment> comment) {
        this.comment=comment;
        this.content=article.getContent();
        this.count=article.getCount();
        this.createTime=article.getCreateTime();
        this.user=article.getUser();
        this.imageUrl=article.getImageUrl();
        this.id=article.getId();
        this.time= TimeUtil.formatDate(article.getCreateTime());
    }
}
