package jm.com.example.springbootrest.rest;

import jm.com.example.springbootrest.dto.UserDTO;
import jm.com.example.springbootrest.mappers.UserMapper;
import jm.com.example.springbootrest.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserRestControllerV1 {
    @GetMapping(value = "/current/")
    public ResponseEntity<UserDTO> getCurrent() {
        User currentUser = (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return new ResponseEntity<>(UserMapper.INSTANCE.toDTO(currentUser), HttpStatus.OK);
    }
}
