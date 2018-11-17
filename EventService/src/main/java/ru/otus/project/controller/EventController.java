package ru.otus.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event")
public class EventController {

    @PostMapping
    @CrossOrigin(origins = "http://localhost:8081")
    public @ResponseBody ResponseEntity<String> eventListener(@RequestBody String body) {
        System.out.println(body);
        return ResponseEntity.ok("Ok");
    }
}
