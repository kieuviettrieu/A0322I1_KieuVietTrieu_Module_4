package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class HomeController {

    @GetMapping("/home")
    public String showHomePage()
    {
        return "home";
    }

    @GetMapping("/admin")
    public String showAdminPage()
    {
        return "admin";
    }

    @GetMapping("/user")
    public String showUserPage()
    {
        return "user";
    }

    @GetMapping("/error403")
    public String showError()
    {
        return "error403";
    }

}
