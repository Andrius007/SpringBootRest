package jm.com.example.springbootrest.mappers;

import jm.com.example.springbootrest.dto.UserDTO;
import jm.com.example.springbootrest.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO toDTO(User user);

}
