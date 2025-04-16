package com.sprinboot.ormmapping.model;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String name;
    private ProfileDTO profile;
    private DoctorDTO doctor;
    private StudentDTO student;

}
