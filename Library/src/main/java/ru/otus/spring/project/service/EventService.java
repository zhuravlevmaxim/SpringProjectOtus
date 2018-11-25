package ru.otus.spring.project.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring.project.domain.Event;
import ru.otus.spring.project.repository.EventRepository;

@Service
public class EventService {

    private EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @HystrixCommand(commandKey = "saveEvent", groupKey = "EventService")
    public void saveEvent(Event event) {
        eventRepository.save(event);
    }
}