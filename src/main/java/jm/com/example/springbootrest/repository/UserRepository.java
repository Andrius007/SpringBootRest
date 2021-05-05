package jm.com.example.springbootrest.repository;

import jm.com.example.springbootrest.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByUsername(String username);
}
