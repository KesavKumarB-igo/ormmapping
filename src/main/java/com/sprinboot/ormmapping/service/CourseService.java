package com.sprinboot.ormmapping.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprinboot.ormmapping.entity.Course;
import com.sprinboot.ormmapping.mapper.CourseMapper;
import com.sprinboot.ormmapping.model.CourseDTO;
import com.sprinboot.ormmapping.repository.CourseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseService {

	@Autowired
    private CourseRepository courseRepository;

	@Autowired
	private CourseMapper courseMapper;

    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = courseMapper.toEntity(courseDTO);
        return courseMapper.toDto(courseRepository.save(course));
    }

    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll()
                .stream().map(courseMapper::toDto).collect(Collectors.toList());
    }

    public CourseDTO getCourseById(Long id) {
        return courseRepository.findById(id)
                .map(courseMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }
    
    public CourseDTO updateProfile(Long id, CourseDTO dto) {
		if(!courseRepository.existsById(id))
		{
			throw new RuntimeException("Course not found");
		}
        Course course = courseMapper.toEntity(dto);
        course.setId(id);
        return courseMapper.toDto(courseRepository.save(course));
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
