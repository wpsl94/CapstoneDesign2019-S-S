package com.capstonedesign.backend.domain;

import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;

@Data
public class Comment {

    @Id
    @Generated
    private Long cid;

    private String parentId;

    private String writerMid;

    private String content;

    private int like;

    private Long date;
}
