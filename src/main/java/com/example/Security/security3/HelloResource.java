package com.example.Security.security3;

import com.example.Security.Profile;
import com.example.Security.ProfileEntity;
import com.example.Security.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        users.setRole("USER");
        users.setEnabled(true);


        profileRepository.save(users);

        return "User Ali Created";
    }
}
