package com.sprinboot.ormmapping.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class DoctorDTO {

	private Long id;
	private String name;
    private UserDTO user;
    private List<AppointmentDTO> appointments = new ArrayList<>();

}
