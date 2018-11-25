package ru.otus.spring.project.repository;

import org.springframework.data.repository.CrudRepository;
import ru.otus.spring.project.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByUserName(String userName);
}
