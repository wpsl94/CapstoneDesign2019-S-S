package com.capstonedesign.backend.domain;

import lombok.Data;

@Data
public class Comment {

    private String parentId;

    private String writerMid;

    private String content;

    private int like;

    private Long date;
}
