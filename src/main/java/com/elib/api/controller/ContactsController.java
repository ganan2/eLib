package com.elib.api.controller;

import com.elib.api.domain.Contacts;
import com.elib.api.domain.User;
import com.elib.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
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
    public String contactsPost(@RequestParam String keyword, Model model, Principal principal) {

        User loggedUser = userRepository.findByUsername(principal.getName());
        Set<User> contactsSearchResults = new HashSet<>();
        Set<Contacts> contactsSet = loggedUser.getContacts();
        contactsSet.forEach(e -> {
            if (e.getUser().getUsername().contains(keyword)
                    || e.getUser().getEmail().contains(keyword)
                    || e.getUser().getFirstName().contains(keyword)
                    || e.getUser().getLastName().contains(keyword)) {
                contactsSearchResults.add(e.getUser());
            }
        });

        model.addAttribute("contactSearchResults", contactsSearchResults);
        return "contacts/contacts";
    }

}
