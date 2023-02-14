package com.example.security2;

import com.example.Security.Profile;
import com.example.Security.ProfileEntity;
import com.example.Security.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloResource {

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/test")
    public String hello() {
        System.out.println("Test ga keldi");
        return "Hello barchaga";
    }

    @GetMapping("/create")
    public String createUser() {
        Profile users = new Profile();
        users.setUserName("Ali");
        users.setPassword("alijon");
        users.setRole(String.valueOf(ROLES.ROLE_USER));
        users.setEnabled(true);

        this.profileRepository.save(users);

        return "User Ali Created";
    }
    @GetMapping("/create/admin")
    public String createAdmin() {
        Profile users = new Profile();
        users.setUserName("admin");
        users.setPassword("root");
        users.setRole(String.valueOf(ROLES.ROLE_ADMIN));
        users.setEnabled(true);


        this.profileRepository.save(users);

        return "Admin Created";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/forUser")
    public String onlyForUser() {
        System.out.println("Test ga keldi");
        return "Hello barchaga";
    }

}