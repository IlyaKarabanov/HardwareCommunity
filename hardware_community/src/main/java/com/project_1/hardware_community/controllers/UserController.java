package com.project_1.hardware_community.controllers;

import com.project_1.hardware_community.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("users")
    public String userList(Model model) {

        model.addAttribute("users", userRepository.findAll());

        return "users";
    }
}
