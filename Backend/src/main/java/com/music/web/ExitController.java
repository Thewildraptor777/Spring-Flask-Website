package com.music.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ExitController {
    
    @GetMapping("/")
    public String exit(){
        return "exit.html";
    }
    
}
