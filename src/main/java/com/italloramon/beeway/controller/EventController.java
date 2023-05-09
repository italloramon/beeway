package com.italloramon.beeway.controller;

import com.italloramon.beeway.dto.EventDtoRequest;
import com.italloramon.beeway.dto.UserDto;
import com.italloramon.beeway.model.Event;
import com.italloramon.beeway.model.User;
import com.italloramon.beeway.service.EventService;
import com.italloramon.beeway.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;
    private final ModelMapper modelMapper;
    private final UserService userService;
    @GetMapping("/events")
    public String listAllEvents(Model model, HttpSession httpSession) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        User user = userService.findUserByEmail(username);
        httpSession.setAttribute("user", user);

        model.addAttribute("events", eventService.findAll());
        return "events";
    }

    @GetMapping("/events/add")
    public String showAddEventForm(Model model) {
        EventDtoRequest eventDtoRequest = new EventDtoRequest();
        model.addAttribute("event", eventDtoRequest);

        return "add_event_form";
    }

    @PostMapping("/events/add")
    public String addEvent(@ModelAttribute("event") EventDtoRequest eventDtoRequest, HttpSession httpSession) {
        eventDtoRequest.setCreatedBy((User) httpSession.getAttribute("user"));
        eventDtoRequest.setCurrentVouchers(new ArrayList<>());
        eventService.saveEvent(eventDtoRequest);

        return "redirect:/events?success";
    }
}
