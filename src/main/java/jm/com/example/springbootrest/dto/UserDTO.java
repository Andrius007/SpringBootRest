package jm.com.example.springbootrest.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private long id;
    private String username;
    private int age;
    private String password;
    private List<RoleDTO> roles;
}
