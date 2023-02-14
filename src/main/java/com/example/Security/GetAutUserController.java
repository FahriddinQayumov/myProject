package com.example.Security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Collection;

@RestController
@RequestMapping(value = "/method")
public class GetAutUserController {

    @RequestMapping(value = "/security")
    public String currentUserNameSimple() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String currentPrincipalName = authentication.getName();

//        authentication.getPrincipal()

        System.out.println(currentPrincipalName);

        return "User http method " + currentPrincipalName;
    }

    @RequestMapping(value = "/principle")
    public String userPrinciple(Principal principal) {
        String userName = principal.getName();
        System.out.println(principal);
        return "User Principle method";
    }

    @RequestMapping(value = "/authentication")
    public String currentUserName(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("User has authorities: " + userDetails.getAuthorities());
        return authentication.getName();
    }

    @RequestMapping(value = "/http")
    public String currentUserNameSimple(HttpServletRequest request) {
        Principal userPrincipal = request.getUserPrincipal();
        String userName = userPrincipal.getName();
        return "User http method: " + userName;
    }

    @RequestMapping(value = "/detail")
    public String userDetailM(@AuthenticationPrincipal final UserDetails userDetails) {
        String userName = userDetails.getUsername();
        String userPassword = userDetails.getPassword();

        Collection roles = userDetails.getAuthorities();
        roles.forEach(System.out::println);
        String s = "userName: " + userName + "\n" + "UserPassword: " + userPassword + "\n" + " roles: " + roles;
        return "User Detail method.   " + s;
    }

}
