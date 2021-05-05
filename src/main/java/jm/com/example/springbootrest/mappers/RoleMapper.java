package jm.com.example.springbootrest.mappers;

import jm.com.example.springbootrest.dto.RoleDTO;
import jm.com.example.springbootrest.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDTO toDTO(Role role);
}
