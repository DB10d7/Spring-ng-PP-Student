package com.programming.techie.springngblog.service;

import com.programming.techie.springngblog.dto.StudentDto;
import com.programming.techie.springngblog.exception.PostNotFoundException;
import com.programming.techie.springngblog.model.Student;
import com.programming.techie.springngblog.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class StudentService {

    @Autowired
    private AuthService authService;
    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public List<StudentDto> showAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(this::mapFromStudentToDto).collect(toList());
    }
    @Transactional
    public StudentDto readSingleStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new PostNotFoundException("For id " + id));
        return mapFromStudentToDto(student);
    }
    @Transactional
    public void createStudent(StudentDto studentDto) {
        Student student = mapFromDtoToStudent(studentDto);
        studentRepository.save(student);
    }
    private StudentDto mapFromStudentToDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(student.getStudentId());
        studentDto.setStudentName(student.getStudentName());
        studentDto.setStudentEmail(student.getStudentEmail());
        return studentDto;
    }
    private Student mapFromDtoToStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setStudentName(studentDto.getStudentName());
        student.setStudentEmail(studentDto.getStudentEmail());
        student.setCreatedOn(Instant.now());
        student.setUpdatedOn(Instant.now());
        return student;
    }

}
