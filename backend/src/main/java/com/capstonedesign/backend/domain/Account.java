package com.capstonedesign.backend.domain;

import lombok.Data;
import lombok.Generated;

@Data
public class Account {

    @Generated
    private Long id;

    private String userMid;

    private String password;

    private String email;

    private String gender;

    private String phoneNumber;

    private String permission;

    private Long registerDate;
}
