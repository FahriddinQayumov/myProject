package com.example.Security.security3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @RequestMapping(value = "/admin")
    public String onlyAdmin() {
        return String.valueOf("Admin admin ");
    }

    @RequestMapping(value = "/test")
    public String adminTest() {
        return String.valueOf("Admin test");
    }
}
