
package com.webspringboot.webspringdemo.controller;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.autoconfigure.ServerProperties.Reactive.Session;

import com.webspringboot.webspringdemo.service.UserDataService;
import com.webspringboot.webspringdemo.entity.LoginUser;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class LoginController {

    @Autowired
    UserDataService authService;

    @GetMapping({"/login", "/"})
    public String Login()
    {
        return "login"; // This will return the login.html template from src/main/resources/templates
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,HttpSession session) throws Exception {

        System.out.println("/login");
        LoginUser user = new LoginUser();
        user.username = username;
        user.password = password;
        boolean isValid = authService.validateUser(user);

    if (!isValid) {
        model.addAttribute("error", "Invalid credentials");
        return "login";
    }
    
    // On successful login, redirect to home page
    // Craete Session here if needed
    session.setAttribute("username", username);
    return "redirect:/home";
}

    @GetMapping("/home")
public String home(HttpSession session, Model model) {

    String username = (String) session.getAttribute("username");

    // Optional: protect page if session expired
    if (username == null) {
        return "redirect:/login";
    }

    model.addAttribute("username", username);
    return "home";   // home.html
}

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        //clear session or any other logout operations can be performed here
        session.invalidate();
        return "redirect:/login";
    }
    

    
}
