package com.webspringboot.webspringdemo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.webspringboot.webspringdemo.service.UserDataService;

@RestController
public class LoginAPI
{
      @Autowired
      private UserDataService userDataService;

      // @PostMapping(value = "/authenticateUser")
      // public boolean authenticateUser(@RequestBody LoginUser user)
      // {
      // boolean isAuthenticated = userDataService.validateUser(user);
      // return isAuthenticated;
      // }


      //send response as json array
      @GetMapping(value = "/getUserData")
      public Object getUserData()
      {
      return userDataService.getUserData();
      }

}
