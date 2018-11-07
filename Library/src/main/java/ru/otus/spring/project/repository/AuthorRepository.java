package ru.otus.spring.project.repository;

import org.springframework.data.repository.CrudRepository;
import ru.otus.spring.project.entity.AuthorEntity;

import java.util.List;

public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {

    List<AuthorEntity> findAll();
}
