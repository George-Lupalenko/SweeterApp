package com.sweeter.controller;

import com.sweeter.domain.User;
import com.sweeter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class registrationController {
    @Autowired
    UserService userService;
    @GetMapping("/registration")
    public String registartion(){
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(User user , Map<String , Object> model){
        if(!userService.addUser(user)){
            model.put("message" , "User exist!");
            return "registration";
        }

        return "redirect:/login";
    }
    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActivated = userService.activateUser(code);

        if (isActivated) {
            model.addAttribute("message", "User successfully activated");
        } else {
            model.addAttribute("message", "Activation code is not found!");
        }

        return "login";
    }
}
