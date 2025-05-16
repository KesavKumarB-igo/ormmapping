package com.sprinboot.ormmapping.mapper;

import org.mapstruct.Mapper;

import com.sprinboot.ormmapping.entity.Profile;
import com.sprinboot.ormmapping.model.ProfileDTO;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

	ProfileDTO toDto(Profile profile);
    Profile toEntity(ProfileDTO dto);
}
