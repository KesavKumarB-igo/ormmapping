package com.sprinboot.ormmapping.model;

import java.util.List;

import lombok.Data;

@Data
public class CourseDTO {
    
    private Long id;
    private String title;
    private List<StudentDTO> students;

}
