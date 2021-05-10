package jm.com.example.springbootrest.rest;

import jm.com.example.springbootrest.dto.RoleDTO;
import jm.com.example.springbootrest.dto.UserDTO;
import jm.com.example.springbootrest.mappers.RoleMapper;
import jm.com.example.springbootrest.mappers.UserMapper;
import jm.com.example.springbootrest.model.Role;
import jm.com.example.springbootrest.model.User;
import jm.com.example.springbootrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/users/")
public class AdminRestControllerV1 {
    private final UserService userService;

    @Autowired
    public AdminRestControllerV1(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") Long userId) {
        if (userId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User user = userService.show(userId);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(UserMapper.INSTANCE.toDTO(user), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        this.userService.save(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping(value = "")
    public ResponseEntity<User> updateUser(@RequestBody User user) {

        this.userService.save(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
        User user = this.userService.show(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.userService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping(value = "")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> users = this.userService.getAllUsers();
        List<UserDTO> userDTOs = users.stream().map(UserMapper.INSTANCE::toDTO).collect(Collectors.toList());

        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userDTOs, HttpStatus.OK);
    }

    @GetMapping(value = "/roles/")
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        List<Role> roles = this.userService.getRoles();
        List<RoleDTO> roleDTOs = roles.stream().map(RoleMapper.INSTANCE::toDTO).collect(Collectors.toList());

        if (roles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(roleDTOs, HttpStatus.OK);
    }
}
