package com.adit.studentmanagement.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.adit.studentmanagement.dto.v1.StudentRequestDTO;
import com.adit.studentmanagement.dto.v1.StudentResponseDTO;
import org.springframework.stereotype.Service;

import com.adit.studentmanagement.entity.Student;
import com.adit.studentmanagement.exception.StudentNotFoundException;
import com.adit.studentmanagement.repository.StudentRepository;
import com.adit.studentmanagement.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO dto) {
        Student student = new Student(null, dto.getName(), dto.getEmail(), dto.getCourse());
        return mapToDTO(repository.save(student));
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponseDTO getStudentById(Long id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id " + id));
        return mapToDTO(student);
    }

    @Override
    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id " + id));

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setCourse(dto.getCourse());

        return mapToDTO(repository.save(student));
    }

    @Override
    public void deleteStudent(Long id) {
        if (!repository.existsById(id)) {
            throw new StudentNotFoundException("Student not found with id " + id);
        }
        repository.deleteById(id);
    }

    private StudentResponseDTO mapToDTO(Student student) {
        return new StudentResponseDTO(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getCourse()
        );
    }
}
