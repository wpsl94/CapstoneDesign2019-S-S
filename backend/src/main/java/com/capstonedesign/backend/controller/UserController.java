package com.capstonedesign.backend.controller;

import com.capstonedesign.backend.domain.Account;
import com.capstonedesign.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/register")
    public void register(@RequestBody Account account) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setRegisterDate(System.currentTimeMillis());

        userService.createNewAccount(account);
    }

    @GetMapping(path = "/userinfo")
    public Account userInfo(@RequestBody Account account) {
        return userService.getUserInfo(account.getId());
    }

    @PostMapping(path = "/idvalidcheck")
    public boolean idValidCheck(@RequestBody Account account) {

        return userService.isAlreadyExistUserId(account);
    }

    @PostMapping(path = "/changecup")
    public void changeCup(@RequestBody Account account) {

        userService.saveCurrentCup(account);
    }

    @PostMapping(path = "/onedrink")
    public void oneDrink(@RequestBody Account account) {

        userService.saveOneDrink(account);
    }

    @PostMapping(path = "/changecurrentproduct")
    public void saveCurrentCup(@RequestBody Account account) {

        userService.changeCurrentProduct(account);
    }
}
