package com.sprinboot.ormmapping.mapper;

import org.mapstruct.Mapper;

import com.sprinboot.ormmapping.entity.User;
import com.sprinboot.ormmapping.model.UserDTO;

@Mapper(componentModel = "spring", uses = {ProfileMapper.class, DoctorMapper.class, StudentMapper.class})
public interface UserMapper {
    UserDTO toDto(User user);
    User toEntity(UserDTO userDTO);
}
