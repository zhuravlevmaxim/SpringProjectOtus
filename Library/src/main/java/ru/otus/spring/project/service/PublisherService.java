package ru.otus.spring.project.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.project.entity.PublisherEntity;
import ru.otus.spring.project.repository.PublisherRepository;

import java.util.List;

@Service
public class PublisherService {

    private PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<PublisherEntity> findAll() {
        return publisherRepository.findAll();
    }

    public PublisherEntity findById(Long id) {
        return publisherRepository.findById(id).get();
    }

    public void deleteById(Long id) {
        publisherRepository.deleteById(id);
    }
}
