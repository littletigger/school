package com.ctbu.school.dto;

import com.ctbu.school.model.Article;
import com.ctbu.school.model.Comment;
import lombok.Data;

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

    public IndexDto(Article article, List<Comment> comment) {
        this.comment=comment;
        this.content=article.getContent();
        this.count=article.getCount();
        this.createTime=article.getCreateTime();
        this.user=article.getUser();
        this.imageUrl=article.getImageUrl();
    }
}
