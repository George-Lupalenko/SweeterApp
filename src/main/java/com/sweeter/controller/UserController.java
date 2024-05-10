package com.sweeter.controller;

import com.sweeter.domain.Role;
import com.sweeter.domain.User;
import com.sweeter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String UserList(Model model){
        model.addAttribute("users" ,userService.findAll());
        return "userList";
    }
    @GetMapping("{user}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String userEditForm(@PathVariable User user , Model model){
        model.addAttribute("user" , user);
        model.addAttribute("roles" , Role.values());
        return "userEdit";
    }
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String procesingUserInput(
            @RequestParam String action,
            @RequestParam String username,
            @RequestParam Map<String , String> form,
            @RequestParam("userId") User user
    ){
        if (action.equals("save")) {
            userService.saveUser(user , username ,form);
        } else if (action.equals("delete")) {
            userService.deleteUser(user);
        }

        return "redirect:/user";
    }
    @GetMapping("profile")
    public String getProfile(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());

        return "profile";
    }

    @PostMapping("profile")
    public String updateProfile(
            @AuthenticationPrincipal User user,
            @RequestParam String password,
            @RequestParam String email
    ) {
        userService.updateProfile(user, password, email);

        return "redirect:/user/profile";
    }
}
