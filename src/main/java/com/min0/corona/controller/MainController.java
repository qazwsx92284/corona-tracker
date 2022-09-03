package com.min0.corona.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String root (Model model) {
        // model allows us to inject certain variables into our template
        model.addAttribute("test1", "Hello user this is value");
        return "mainTemplate";
    }
}
