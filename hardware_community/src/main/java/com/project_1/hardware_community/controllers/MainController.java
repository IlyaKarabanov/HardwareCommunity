package com.project_1.hardware_community.controllers;

import com.project_1.hardware_community.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/run")
    public String rum() {
        return "run";
    }

    @GetMapping("/")
    public String home(Model model, Authentication authentication) {

        boolean home;

        try {
            home = authentication.isAuthenticated();
        } catch (Exception e) {
            home = false;
        }

        if (home) {
            model.addAttribute("home", home);
        } else {
            model.addAttribute("home", home);
        }

        return "home";
    }

    @GetMapping("/about")
    public String aboutPage(Model model, Authentication authentication) {

        boolean home;

        try {
            home = authentication.isAuthenticated();
        } catch (Exception e) {
            home = false;
        }

        if (home) {
            model.addAttribute("home", home);
        } else {
            model.addAttribute("home", home);
        }

        return "about";
    }
}
