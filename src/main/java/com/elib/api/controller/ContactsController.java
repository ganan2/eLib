package com.elib.api.controller;

import com.elib.api.repositories.ContactsRepository;
import com.elib.api.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactsRepository contactsRepository;

    @Autowired
    private ContactsService contactsService;

    @RequestMapping(method = RequestMethod.GET)
    public String contactGet() {
        return "/contacts/contacts";
    }

}
