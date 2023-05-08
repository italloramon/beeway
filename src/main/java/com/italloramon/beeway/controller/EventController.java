package com.italloramon.beeway.controller;

import com.italloramon.beeway.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping("/events")
    public String listAllEvents(Model model) {
        model.addAttribute("events", eventService.findAll());
        return "events";
    }
}
