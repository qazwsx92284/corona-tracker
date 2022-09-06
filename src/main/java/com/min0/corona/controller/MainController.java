package com.min0.corona.controller;

import com.min0.corona.service.CoronaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {

    private final CoronaService coronaService;

    @GetMapping("/")
    public String root (Model model) throws IOException {
        // model allows us to inject certain variables into our template
        model.addAttribute("test1", "Hello user this is value");
        coronaService.populateDatabase();
        return "mainTemplate";
    }
}
