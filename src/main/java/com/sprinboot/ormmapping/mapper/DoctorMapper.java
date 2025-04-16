package com.sprinboot.ormmapping.mapper;

import org.mapstruct.Mapper;

import com.sprinboot.ormmapping.entity.Doctor;
import com.sprinboot.ormmapping.model.DoctorDTO;

@Mapper(componentModel = "spring", uses = {UserMapper.class, AppointmentMapper.class})
public interface DoctorMapper {
    DoctorDTO toDto(Doctor doctor);
    Doctor toEntity(DoctorDTO dto);
}