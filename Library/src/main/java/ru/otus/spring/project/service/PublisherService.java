package ru.otus.spring.project.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.project.entity.PublisherEntity;
import ru.otus.spring.project.repository.PublisherRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PublisherService {

    private PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @HystrixCommand(commandKey = "findAllPublisher", groupKey = "PublisherService")
    public List<PublisherEntity> findAll() {
        return publisherRepository.findAll();
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @HystrixCommand(commandKey = "findPublisherById", groupKey = "PublisherService")
    public PublisherEntity findById(Long id) {
        return publisherRepository.findById(id).get();
    }

    @Secured({"ROLE_ADMIN"})
    @HystrixCommand(commandKey = "deletePublisherById", groupKey = "PublisherService")
    @Transactional(readOnly = false)
    public void deleteById(Long id) {
        publisherRepository.deleteById(id);
    }
}
