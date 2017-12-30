package com.elib.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddController {

    @RequestMapping(value = "/add")
    public @ResponseBody
    String getContact(@RequestParam("username") String username) {

        return "Added";
    }
}
