package uz.grand.grandacademy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class UserLoginController {

    @GetMapping
    public String getLoginPage(){
        return "login/login";
    }
    @PostMapping
    public String login(){
       return  "login/success";
    }
}
