package com.example.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hello")
public class HelloResource {

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/test")
    public String hello() {
        return "Hello barchaga";
    }

    @GetMapping("/create")
    public String createUser() {
        Profile users = new Profile();
        users.setUserName("Ali");
        users.setPassword("alijon");
        users.setRole("ROLE_USER");
        users.setEnabled(true);


        this.profileRepository.save(users);

        return "User Ali Created";
    }

    @PostMapping
    public String registration(@RequestBody Profile profile){
        Profile users = new Profile();
        users.setUserName(profile.getUserName());
        users.setPassword(profile.getPassword());
        users.setRole("ROLE_USER");
        users.setEnabled(true);


        this.profileRepository.save(users);

        return "User Ali Created";
    }
}
