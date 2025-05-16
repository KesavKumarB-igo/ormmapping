package com.sprinboot.ormmapping.mapper;

import org.mapstruct.Mapper;

import com.sprinboot.ormmapping.entity.Student;
import com.sprinboot.ormmapping.model.StudentDTO;

@Mapper(componentModel = "spring", uses = {UserMapper.class, CourseMapper.class})
public interface StudentMapper {
    StudentDTO toDto(Student student);
    Student toEntity(StudentDTO dto);
}