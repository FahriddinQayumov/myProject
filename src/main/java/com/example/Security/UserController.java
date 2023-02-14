package com.example.Security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/test")
    public String test() {
        return "User test";
    }

    @RequestMapping(value = "/user")
    public String onlyUser() {
        return "User user ";
    }

    @RequestMapping("/baho-korish")
    public String baho_korish(){
        return "Baho 5 ekan";
    }
}
