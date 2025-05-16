package com.sprinboot.ormmapping.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprinboot.ormmapping.entity.Student;
import com.sprinboot.ormmapping.mapper.StudentMapper;
import com.sprinboot.ormmapping.model.StudentDTO;
import com.sprinboot.ormmapping.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

	@Autowired
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentDTO createStudent(StudentDTO dto) {
        Student student = studentMapper.toEntity(dto);
        return studentMapper.toDto(studentRepository.save(student));
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }

    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return studentMapper.toDto(student);
    }

    public StudentDTO updateStudent(Long id, StudentDTO dto) {
    	if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found");
        }
        Student student = studentMapper.toEntity(dto);
        student.setId(id);
        return studentMapper.toDto(studentRepository.save(student));
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
