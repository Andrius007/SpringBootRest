package jm.com.example.springbootrest.repository;

import jm.com.example.springbootrest.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
