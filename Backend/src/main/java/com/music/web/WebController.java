package com.music.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/") 
    public String website(Model model) {
        model.addAttribute("test","tester");
        return "index.html";
    }
}
