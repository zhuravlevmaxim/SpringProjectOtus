package ru.otus.spring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.spring.project.domain.Event;
import ru.otus.spring.project.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {

    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public @ResponseBody ResponseEntity<String> event(@RequestBody Event event) {
        eventService.saveEvent(event);
        return ResponseEntity.ok("OK");
    }
}
