package com.example.Security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/any")
public class AnyController {
    @GetMapping(value = "/test")
    public String testMethod() {
        return "API WORKING";
    }

}
