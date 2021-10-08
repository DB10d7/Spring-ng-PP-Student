package com.programming.packetPrep.springngStudent.repository;

import com.programming.packetPrep.springngStudent.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
