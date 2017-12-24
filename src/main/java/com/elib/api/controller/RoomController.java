package com.elib.api.controller;

import com.elib.api.domain.Room;
import com.elib.api.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @RequestMapping(value = "/room", method = RequestMethod.GET)
    public String getFeedback(Model model){
        Room room = new Room();
        return "room";
    }

    @RequestMapping(value = "/room", method = RequestMethod.POST)
    public String saveFeedback(@ModelAttribute("contact_us") @Valid Room room){
        roomRepository.save(room);
        return "redirect:/room?success";
    }
}
