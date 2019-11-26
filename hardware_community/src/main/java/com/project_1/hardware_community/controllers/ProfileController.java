package com.project_1.hardware_community.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("profile")
    public String addList(Model model, Authentication authentication) {
        model.addAttribute("auth",
                authentication.getAuthorities().contains(new SimpleGrantedAuthority("USER")));
        return "profile";
    }
}
