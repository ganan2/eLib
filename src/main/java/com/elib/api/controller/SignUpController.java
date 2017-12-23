package com.elib.api.controller;

import com.elib.api.domain.User;
import com.elib.api.domain.security.UserRole;
import com.elib.api.repositories.RoleRepository;
import com.elib.api.service.UserService;
import com.elib.api.service.serviceImpl.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
public class SignUpController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    private static final Logger LOG = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {
        User user = new User();

        model.addAttribute("user", user);

        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@ModelAttribute("user") @Valid User user, Model model, BindingResult bindingResult) {
        if (userService.checkUserExists(user.getUsername(), user.getEmail())) {

            if (userService.checkEmailExists(user.getEmail())) {
                model.addAttribute("Email exists", true);
            }

            if (userService.checkUsernameExists(user.getUsername())) {
                model.addAttribute("Username Exists", true);
            }

            return "signup";
        } else {

            if(bindingResult.hasErrors()){
                LOG.info("Errors------------------->> {}", bindingResult.getAllErrors());
            }

            Set<UserRole> userRoles = new HashSet<>();
            userRoles.add(new UserRole(user, roleRepository.findByName("ROLE_USER")));
            userService.createUser(user, userRoles);
        }

            return "redirect:/signup?success";
    }
}
