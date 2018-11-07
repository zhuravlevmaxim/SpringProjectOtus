package ru.otus.spring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.spring.project.entity.PublisherEntity;
import ru.otus.spring.project.service.PublisherService;

import java.util.List;

@RestController("/publisher")
public class PublisherController {

    private PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public @ResponseBody List<PublisherEntity> findAll() {
        return publisherService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody PublisherEntity findById(@PathVariable Long id) {
        return publisherService.findById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id) {
        publisherService.deleteById(id);
    }
}
