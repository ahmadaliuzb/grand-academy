package uz.grand.grandacademy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class UserRegisterControllerV1 {
    @GetMapping
    public String getRegisterPage(){
        return "register/register";
    }

    @PostMapping()
    public String register(@RequestParam(value = "name") String name,
                           @RequestParam(value = "email") String email,
                           @RequestParam(value = "phone") String phone) {
        System.out.println(name);
        System.out.println(email);
        System.out.println(phone);
        return "register/success";

    }
}
