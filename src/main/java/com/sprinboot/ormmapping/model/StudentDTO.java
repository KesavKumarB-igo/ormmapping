package com.sprinboot.ormmapping.model;

import java.util.List;

import lombok.Data;

@Data
public class StudentDTO {
    
    private Long id;
    private String name;
    private UserDTO user;
    private List<CourseDTO> courses;
	
}
