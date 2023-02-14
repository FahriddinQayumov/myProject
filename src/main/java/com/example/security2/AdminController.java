package com.example.security2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @RequestMapping(value = "/test")
    public String init() {
        return "Init";
    }
}
