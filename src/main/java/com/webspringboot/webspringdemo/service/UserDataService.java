package com.webspringboot.webspringdemo.service;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webspringboot.webspringdemo.repository.UserRepository;
import com.webspringboot.webspringdemo.entity.LoginUser;
import com.webspringboot.webspringdemo.entity.UserData;

@Service
public class UserDataService
{
    @Autowired
    private UserRepository userRepository;

    public boolean validateUser(LoginUser user)
    {
    return userRepository.validateUser(user);
    }

    public ArrayList<UserData> getUserData()
    {
    return userRepository.getUserData();
    }


}