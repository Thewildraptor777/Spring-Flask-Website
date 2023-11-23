package com.music.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.music.web.database.Check;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:5000/")
public class LoginController {
    @PostMapping("/login")
    public String website(@RequestParam("username") String username,
                          @RequestParam("password") String password) {
        Check user = new Check(username, password);
        return user.getPlaylistData();
    }
}



