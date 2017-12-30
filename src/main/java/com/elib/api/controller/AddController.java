package com.elib.api.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddController {

    private org.slf4j.Logger LOG = LoggerFactory.getLogger(AddController.class);

    @RequestMapping(value = "/add", params = "username")
    public void getContact(@PathVariable String username){

        String string = null;
    }
}
