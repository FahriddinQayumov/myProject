package com.example.Security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/secured")
public class SecuredController {

    @RequestMapping(value = "/init")
    public String init() {
        return "Init";
    }

    @RequestMapping(value = "/test")
    public String test() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();
        return "Secured test "+ principal;
    }
}
