package com.example.security2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RolesAllowed("USER")
@RestController
@RequestMapping(value = "/moderator")
public class ModeratorController {

    @RequestMapping( "/init")
    public String init() {
        return "Init";
    }
}
