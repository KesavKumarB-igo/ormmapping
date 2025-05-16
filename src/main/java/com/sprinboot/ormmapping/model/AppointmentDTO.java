package com.sprinboot.ormmapping.model;

import lombok.Data;

@Data
public class AppointmentDTO {

	private Long id;
	private String time;
    private DoctorDTO doctor;
}
