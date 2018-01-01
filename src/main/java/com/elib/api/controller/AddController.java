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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Controller
public class AddController {

    private static String isAdded = "Add";

    private static boolean addFlag = true;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactsRepository contactsRepository;

    @RequestMapping(value = "/add")
    public @ResponseBody String getContact(@RequestParam("username") String username, Principal principal) {

        User loggedUser = userRepository.findByUsername(principal.getName());

        Iterator<Contacts> iterator = loggedUser.getContacts().iterator();
        while(iterator.hasNext()){
            Contacts contacts = iterator.next(); // throws concurrent modification exception
            if(contacts.getContactUsername().equalsIgnoreCase(loggedUser.getUsername())){
                isAdded = "Added";
                continue;
            } else if(contacts.getContactUsername().equalsIgnoreCase(username)){
                isAdded = "Added";
                continue;
            } else {
                Set<Contacts> contactsSet = new HashSet<>();
                Contacts newContact = new Contacts(username, loggedUser);
                contactsSet.add(newContact);
                loggedUser.getContacts().addAll(contactsSet);
                userRepository.save(loggedUser);
            }
        }

        return isAdded;

    }
}
