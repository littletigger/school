package com.ctbu.school.dto;

import lombok.Data;

import java.util.List;

@Data
public class PushInformDto {
    String title;
    String content;
    String author;
    String imageUrl;
    List<Long> classIdList;

}
