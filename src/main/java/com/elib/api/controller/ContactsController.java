package com.elib.api.controller;

import com.elib.api.domain.Contacts;
import com.elib.api.domain.User;
import com.elib.api.repositories.ContactsRepository;
import com.elib.api.repositories.UserRepository;
import com.elib.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;
import java.util.Set;

@Controller
public class ContactsController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactsRepository contactsRepository;

    @Autowired
    private UserService userService;

    private Boolean contactsSearchFlag = false;

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String contactsGet(Model model) {
        Contacts contacts = new Contacts();
        model.addAttribute("contacts", contacts);
        return "/contacts/contacts";
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.POST)
    public String contactsPost(@ModelAttribute("contacts") Contacts contacts, Model model) {

        Set<User> contactsSearchResults = new HashSet<>();
        Set<User> userSet = userRepository.findAll();
        userSet.forEach(e -> {
            if (e.getUsername().contains(contacts.getKeyword())) {
                contactsSearchResults.add(e);
                contactsSearchFlag = true;
            }

            if (e.getEmail().contains(contacts.getKeyword())) {
                contactsSearchResults.add(e);
                contactsSearchFlag = true;
            }

            if (e.getFirstName().contains(contacts.getKeyword())) {
                contactsSearchResults.add(e);
                contactsSearchFlag = true;
            }

            if (e.getLastName().contains(contacts.getKeyword())) {
                contactsSearchResults.add(e);
                contactsSearchFlag = true;
            }
        });

        if(contactsSearchFlag == true){
            contactsRepository.save(contacts);
        }
        model.addAttribute("contactSearchResults", contactsSearchResults);
        return "contacts/search";
    }

}
