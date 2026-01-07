package com.adit.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.adit.studentmanagement.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}