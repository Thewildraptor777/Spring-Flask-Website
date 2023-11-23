package com.music.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.music.web.database.Check;

@Controller
public class WebController {
    @GetMapping("/") 
    public String website(Model model) {
        Check user=new Check("dev", "tester");
        model.addAttribute("test", user.getPlaylistData());
        return "index.html";
    }
}
