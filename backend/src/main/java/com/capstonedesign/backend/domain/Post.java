package com.capstonedesign.backend.domain;

import lombok.Data;

@Data
public class Post {

    private String pid;

    private String title;

    private String content;

    private String mediaPath;

    private String writerMid;

    private int like;

    private Comment comments;

    private Long date;
}
