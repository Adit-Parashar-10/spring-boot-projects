package com.adit.studentmanagement.service;

import java.util.List;
import com.adit.studentmanagement.dto.StudentRequestDTO;
import com.adit.studentmanagement.dto.StudentResponseDTO;

public interface StudentService {

    StudentResponseDTO createStudent(StudentRequestDTO dto);
    List<StudentResponseDTO> getAllStudents();
    StudentResponseDTO getStudentById(Long id);
    StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto);
    void deleteStudent(Long id);
}
