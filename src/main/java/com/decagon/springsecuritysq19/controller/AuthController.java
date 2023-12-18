package com.decagon.springsecuritysq19.controller;

import com.decagon.springsecuritysq19.dto.UserDto;
import com.decagon.springsecuritysq19.serviceImpl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class AuthController {

    private UserServiceImpl userService;

    @Autowired
    public AuthController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(){
        return "index";
    }
    @GetMapping("/sign-up")
    public ModelAndView signUpUser(){

        return new ModelAndView("sign-up")
                .addObject("user", new UserDto());
    }

    @PostMapping("/login")
    public String login(){
        return "dashboard";
    }
    //TODO: I created the method. To handle PostMapping login processing.
    @GetMapping("/dashboard")
    public String dashBoard(){
        return "dashboard";
    }

    //TODO: I made changes on the method above to handle login successUrl processing.

    @PostMapping("/sign-up")
    public String signUp(@ModelAttribute UserDto userDto){
        log.info("User Sign-up info: {}", userDto);
        userService.saveUser.apply(userDto);
        return "index";
    }



    @GetMapping("/logout")
    public String logout(){
        return "index";
    }
}
