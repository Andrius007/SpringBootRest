package jm.com.example.springbootrest.service;

import jm.com.example.springbootrest.model.Role;
import jm.com.example.springbootrest.model.User;

import java.util.List;

public interface UserService  {
    List<User> getAllUsers();
    void save(User user);
    User show(long id);
    void update(long id, User updatedUser);
    void delete(long id);
    List<Role> getRoles();
}
