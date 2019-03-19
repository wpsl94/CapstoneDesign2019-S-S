package com.capstonedesign.backend.domain;

import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;

@Data
public class Post {

    @Id
    @Generated
    private Long pid;

    private String title;

    private String content;

    private String mediaPath;

    private String writerMid;

    private int like;

    private int commentCount;

    private Comment comments;

    private Long date;
}
