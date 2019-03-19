package com.capstonedesign.backend.controller;

import com.capstonedesign.backend.domain.Account;
import com.capstonedesign.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/register")
    public void register(@RequestBody Account account) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setPermission("viewer");
        account.setRegisterDate(System.currentTimeMillis());

        userService.createNewAccount(account);
    }

    @PostMapping(path = "/idvalidcheck")
    public boolean idValidCheck(@RequestBody Account account) {

        return userService.isAlreadyExistUserId(account);
    }
}
