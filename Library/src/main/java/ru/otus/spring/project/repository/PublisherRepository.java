package ru.otus.spring.project.repository;

import org.springframework.data.repository.CrudRepository;
import ru.otus.spring.project.entity.PublisherEntity;

import java.util.List;

public interface PublisherRepository extends CrudRepository<PublisherEntity, Long> {

    List<PublisherEntity> findAll();
}
