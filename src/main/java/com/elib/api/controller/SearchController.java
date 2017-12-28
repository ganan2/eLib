package com.elib.api.controller;

import com.elib.api.domain.Search;
import com.elib.api.domain.User;
import com.elib.api.repositories.SearchRepository;
import com.elib.api.repositories.UserRepository;
import com.elib.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@Controller
public class SearchController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SearchRepository searchRepository;

    @Autowired
    private UserService userService;

    private Boolean searchFlag = false;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchget(Model model) {
        Search search = new Search();
        model.addAttribute("search", search);
        return "/search/search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchPost(@ModelAttribute("search") Search search, Model model) {

        Set<User> searchResults = new HashSet<>();
        Set<User> userSet = userRepository.findAll();
        userSet.forEach(e -> {
            if (e.getUsername().contains(search.getKeyword())) {
                searchResults.add(e);
                searchFlag = true;
            }

            if (e.getEmail().contains(search.getKeyword())) {
                searchResults.add(e);
                searchFlag = true;
            }

            if (e.getFirstName().contains(search.getKeyword())) {
                searchResults.add(e);
                searchFlag = true;
            }

            if (e.getLastName().contains(search.getKeyword())) {
                searchResults.add(e);
                searchFlag = true;
            }
        });

        if(searchFlag == true){
            searchRepository.save(search);
        }
        model.addAttribute("searchResults", searchResults);
        return "search/search";
    }
}