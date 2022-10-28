package uz.grand.grandacademy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uz.grand.grandacademy.dto.UserDTO;
import uz.grand.grandacademy.service.UserService;

import java.util.HashSet;

@Controller
@RequestMapping("/register")
public class UserRegisterControllerV1 {

    @Autowired
    UserService userService;

    @GetMapping("")
    public String getRegisterPage(){
        return "register/register";
    }

    @PostMapping("/send")
    public String register(@RequestParam(value = "name") String name,
                           @RequestParam(value = "email") String email,
                           @RequestParam(value = "password") String password,
                           @RequestParam(value = "phone") String phone,
                           Model model) {
        UserDTO userDTO=new UserDTO(name,email,password,phone,new HashSet<>());
        model.addAttribute("name",name);
        model.addAttribute("email",email);
        model.addAttribute("password",password);
        model.addAttribute("phone",phone);

        //save user
        userService.create(userDTO);
        return "register/success";

    }
}
