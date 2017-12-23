package com.elib.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController {

    private static final String ERROR_PATH = "/error";

    @RequestMapping(value = ERROR_PATH)
    public String error(){
        return "redirect:/contact?maintenance";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
