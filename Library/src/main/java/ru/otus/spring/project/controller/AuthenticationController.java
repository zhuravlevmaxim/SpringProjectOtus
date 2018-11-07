package ru.otus.spring.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthenticationController {

    @RequestMapping("loginpage")
    public String loginPage() {
        return "/loginpage";
    }

    @RequestMapping()
    public String failPage() {
        return "/failpage";
    }
}
