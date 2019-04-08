package com.capstonedesign.backend.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Water {

    @Id
    private Long cid;

    @Id
    private Long uid;

    private String userMid;

    private Integer waterDrink;


}
