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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;

@Controller
public class ContactsController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String contactsGet() {
        return "/contacts/contacts";
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.POST)
    public String contactsPost(@RequestParam String keyword, Model model) {

        Set<User> contactsSearchResults = new HashSet<>();
        Set<User> userSet = userRepository.findAll();
        userSet.forEach(e -> {
            if (e.getUsername().contains(keyword)
                    || e.getEmail().contains(keyword)
                    || e.getFirstName().contains(keyword)
                    || e.getLastName().contains(keyword)) {
                contactsSearchResults.add(e);
            }
        });

        model.addAttribute("contactSearchResults", contactsSearchResults);
        return "contacts/contacts";
    }

}
