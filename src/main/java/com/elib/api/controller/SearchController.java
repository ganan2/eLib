package com.elib.api.controller;

import com.elib.api.domain.User;
import com.elib.api.repositories.UserRepository;
import com.elib.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
public class SearchController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    private Boolean searchFlag = false;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchget(Model model) {
        return "/search/search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchPost(@RequestParam String keyword, Model model) {

        Set<User> searchResults = new HashSet<>();
        Set<User> userSet = userRepository.findAll();
        userSet.forEach(e -> {
            if (e.getUsername().contains(keyword)
                    || e.getEmail().contains(keyword)
                    || e.getFirstName().contains(keyword)
                    || e.getLastName().contains(keyword)) {
                searchResults.add(e);
            }
        });

        model.addAttribute("searchResults", searchResults);
        return "search/search";
    }
}