package by.hibernate_spring.controller;

import by.hibernate_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reg")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String view(){
        return "registration";
    }

    @PostMapping
    public String reg(String name, String username, String password){
        userService.save(name, username, password);
        return "registration";
    }
}
