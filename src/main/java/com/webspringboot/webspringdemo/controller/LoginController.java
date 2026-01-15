
package com.webspringboot.webspringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.webspringboot.webspringdemo.service.UserDataService;
import com.webspringboot.webspringdemo.entity.LoginUser;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    UserDataService authService;

    @GetMapping("/login")
    public String Login()
    {
        return "login"; // This will return the login.html template from src/main/resources/templates
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) throws Exception {

        System.out.println("/login");
        LoginUser user = new LoginUser();
        user.username = username;
        user.password = password;
        boolean isValid = authService.validateUser(user);

    if (!isValid) {
        model.addAttribute("error", "Invalid credentials");
        return "login";
    }

    return "redirect:/home";
}

    @GetMapping("/")
    public String Home()
    {
        return "home"; // This will return the home.html template from src/main/resources/templates
    }

    
}
