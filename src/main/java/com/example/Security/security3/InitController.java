package com.example.Security.security3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/init")
public class InitController {

    @GetMapping(value = "/test")
    public String testMethod() {
        return "API WORKING";
    }

    @GetMapping(value = "/best")
    public String onlyUser() {
        return String.valueOf("Test Best");
    }


}
