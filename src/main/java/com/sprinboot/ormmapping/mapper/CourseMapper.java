package com.sprinboot.ormmapping.mapper;

import org.mapstruct.Mapper;

import com.sprinboot.ormmapping.entity.Course;
import com.sprinboot.ormmapping.model.CourseDTO;

@Mapper(componentModel = "spring", uses = {StudentMapper.class})
public interface CourseMapper {

	CourseDTO toDto(Course course);
    Course toEntity(CourseDTO dto);
}
