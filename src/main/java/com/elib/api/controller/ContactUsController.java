package com.elib.api.controller;

import com.elib.api.domain.ContactUs;
import com.elib.api.repositories.ContactUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class ContactUsController {

    @Autowired
    private ContactUsRepository contactUsRepository;

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String getFeedback(Model model){
        ContactUs contactUs = new ContactUs();
        model.addAttribute("contact_us", contactUs);
        return "contact";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String saveFeedback(@ModelAttribute("contact_us") @Valid ContactUs contactUs){
        contactUsRepository.save(contactUs);
        return "contact";
    }

}
