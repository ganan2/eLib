package com.elib.api.controller;

import com.elib.api.domain.Contacts;
import com.elib.api.domain.User;
import com.elib.api.repositories.ContactsRepository;
import com.elib.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Iterator;

@Controller
public class AddController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactsRepository contactsRepository;

    private static String isAdded = "Add";

    // adding multiple users at a time results in concurrent modification exception. Lambdas may be required.
    @RequestMapping(value = "/add")
    public @ResponseBody
    String getContact(@RequestParam("username") String username, Principal principal) {
        User loggedUser = userRepository.findByUsername(principal.getName());

        loggedUser.getContacts().forEach(e -> {
            if(username.equalsIgnoreCase(e.getUser().getUsername())){
                isAdded = "Added";
            } else {
                isAdded = "Added";
            }
        });

        return isAdded;

    }
}
