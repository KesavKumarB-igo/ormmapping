package com.sprinboot.ormmapping.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprinboot.ormmapping.entity.Appointment;
import com.sprinboot.ormmapping.mapper.AppointmentMapper;
import com.sprinboot.ormmapping.model.AppointmentDTO;
import com.sprinboot.ormmapping.repository.AppointmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private AppointmentMapper appointmentMapper;
	
	public AppointmentDTO createAppointment(AppointmentDTO dto) {
        Appointment appointment = appointmentMapper.toEntity(dto);
        return appointmentMapper.toDto(appointmentRepository.save(appointment));
    }

    public List<AppointmentDTO> getAllAppointments() {
        return appointmentRepository.findAll()
                .stream()
                .map(appointmentMapper::toDto)
                .collect(Collectors.toList());
    }
    public AppointmentDTO getAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        return appointmentMapper.toDto(appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    public AppointmentDTO updateAppointment(Long id, AppointmentDTO dto) {
    	if (!appointmentRepository.existsById(id)) {
            throw new RuntimeException("Appointment not found");
        }
        Appointment updated = appointmentMapper.toEntity(dto);
        updated.setId(id);
        return appointmentMapper.toDto(appointmentRepository.save(updated));
    }
}
