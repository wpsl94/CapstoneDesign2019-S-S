package com.capstonedesign.backend.service;

import com.capstonedesign.backend.domain.Account;
import com.capstonedesign.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createNewAccount(Account account) {

        userRepository.saveAccount(account);
    }

    public boolean isAlreadyExistUserId(Account account) {

        return userRepository.isExistUser(account);
    }
}
