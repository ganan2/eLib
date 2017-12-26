package com.elib.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactsController {

    @RequestMapping("/contacts")
    public String home() {
        return "contacts/contacts";
    }

}
