package com.elib.api.controller;

import com.elib.api.domain.User;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddController {
    
    @RequestMapping(value = "/add")
    public @ResponseBody String getContact(@RequestParam("username") String username){

        return "Added";
    }
}
