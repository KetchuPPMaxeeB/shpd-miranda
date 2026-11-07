package com.miranda.shpd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthCheck {

    @GetMapping("/api/auth-check")
    public String check() {
        return "Checked";
    }
}
