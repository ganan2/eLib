package com.elib.api.controller;

import com.elib.api.domain.User;
import com.elib.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class AddController {

    @Autowired
    private UserRepository userRepository;

    private static String isAdded = "Push to contacts";

    @RequestMapping(value = "/add")
    public @ResponseBody
    String getContact(@RequestParam("username") String username, Principal principal) {
        User loggedUser = userRepository.findByUsername(principal.getName());

        loggedUser.getContacts().forEach(e -> {
            if(username.equalsIgnoreCase(e.getUser().getUsername())){
                isAdded = "Added";
            } else {
                isAdded = "Push to contacts";
            }
        });
        return isAdded;

    }
}
