package com.sprinboot.ormmapping.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprinboot.ormmapping.entity.Doctor;
import com.sprinboot.ormmapping.mapper.DoctorMapper;
import com.sprinboot.ormmapping.model.DoctorDTO;
import com.sprinboot.ormmapping.repository.DoctorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoctorService {

	@Autowired
    private DoctorRepository doctorRepository;
    
	@Autowired
	private DoctorMapper doctorMapper;

    // Create 
    public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = doctorMapper.toEntity(doctorDTO);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return doctorMapper.toDto(savedDoctor);
    }

    // Get All
    public List<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(doctorMapper::toDto)
                .collect(Collectors.toList());
    }

    // Get by ID
    public DoctorDTO getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        return doctorMapper.toDto(doctor);
    }
    
    //Update 
    public DoctorDTO updateDoctor(Long id, DoctorDTO dto) {
    	if (!doctorRepository.existsById(id)) {
            throw new RuntimeException("Doctor not found");
        }
        Doctor doctor = doctorMapper.toEntity(dto);
        doctor.setId(id);
        return doctorMapper.toDto(doctorRepository.save(doctor));
    }

    // Delete
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
