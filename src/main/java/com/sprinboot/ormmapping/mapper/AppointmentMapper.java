package com.sprinboot.ormmapping.mapper;

import org.mapstruct.Mapper;

import com.sprinboot.ormmapping.entity.Appointment;
import com.sprinboot.ormmapping.model.AppointmentDTO;

@Mapper(componentModel = "spring", uses = {DoctorMapper.class})
public interface AppointmentMapper {

	AppointmentDTO toDto(Appointment appointment);
    Appointment toEntity(AppointmentDTO dto);
}
