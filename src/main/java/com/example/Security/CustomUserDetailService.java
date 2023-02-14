package com.example.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("Keldi: loadUserByUsername.");
        Optional<Profile> usersOptional = this.profileRepository.findByUserName(s);
        usersOptional.orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        Profile profile = usersOptional.get();
        System.out.println(profile);

        return new CustomUserDetails(profile);
    }
}
