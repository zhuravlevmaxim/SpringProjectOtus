package ru.otus.spring.project.repository;

import org.springframework.data.repository.CrudRepository;
import ru.otus.spring.project.domain.Event;

public interface EventRepository extends CrudRepository<Event, String> {
}
