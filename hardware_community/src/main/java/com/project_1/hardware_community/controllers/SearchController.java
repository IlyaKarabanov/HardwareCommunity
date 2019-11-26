package com.project_1.hardware_community.controllers;

import com.project_1.hardware_community.domain.Cpu;
import com.project_1.hardware_community.repositories.CpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private CpuRepository cpuRepository;

    /*@GetMapping("/")
    public String searchPage(Authentication authentication, Model model) {

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

        return "search";
    }*/

    @RequestMapping(value="/")
    public String searchResult(@RequestParam String text, Authentication authentication, Model model) {

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

        List<Object> searchList = new ArrayList<>();

        Set<Cpu> cpuResult = new HashSet<>();
        Set<Cpu> gpuResult = new HashSet<>();
        Set<Cpu> ramResult = new HashSet<>();

        CpuRepository cpuRepositoryResult = cpuRepository;

        String[] keyWords = text.split(" ");
        for (int i = 0; i < keyWords.length; i++) {
            if (i == 0) {
                try {
                    cpuResult.addAll(cpuRepository.
                            findByBrandContainsOrNameContainsOrSocketContainsOrCoreContainsOrFrequencyContains
                                    (keyWords[i], keyWords[i],keyWords[i],keyWords[i],keyWords[i]));

                } catch (Exception e) {}

            } else {
                for (Iterator<Cpu> iterator = cpuResult.iterator(); iterator.hasNext();) {
                    if (!iterator.next().contains(keyWords[i])) {
                        iterator.remove();
                    }
                }
            }
        }

        model.addAttribute("searchDefault", text);
        model.addAttribute("cpuResult", cpuResult);

        return "search";
    }
}
