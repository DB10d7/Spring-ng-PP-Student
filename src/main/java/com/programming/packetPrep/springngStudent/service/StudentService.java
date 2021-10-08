package com.programming.packetPrep.springngStudent.service;

import com.programming.packetPrep.springngStudent.dto.StudentDto;
import com.programming.packetPrep.springngStudent.exception.StudentNotFoundException;
import com.programming.packetPrep.springngStudent.model.Student;
import com.programming.packetPrep.springngStudent.repository.StudentRepository;
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
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("For id " + id));
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
        studentDto.setName(student.getName());
        studentDto.setFatherName(student.getFatherName());
        studentDto.setBatch(student.getBatch());
        studentDto.setAge(student.getAge());
        studentDto.setNumber(student.getNumber());
        studentDto.setPassOutYear(student.getPassOutYear());
        return studentDto;
    }
    private Student mapFromDtoToStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setStudentName(studentDto.getStudentName());
        student.setStudentEmail(studentDto.getStudentEmail());
        student.setName(studentDto.getName());
        student.setFatherName(studentDto.getFatherName());
        student.setNumber(studentDto.getNumber());
        student.setBatch(studentDto.getBatch());
        student.setAge(studentDto.getAge());
        student.setPassOutYear(studentDto.getPassOutYear());
        student.setCreatedOn(Instant.now());
        student.setUpdatedOn(Instant.now());
        return student;
    }
    @Transactional
    public String deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return "Student removed !! ";
    }
    @Transactional
    public void updateStudent(StudentDto studentDto) {
        Student student = studentRepository.findById(studentDto.getStudentId()).orElse(null);
        student.setStudentName(studentDto.getStudentName());
        student.setStudentEmail(studentDto.getStudentEmail());
        student.setName(studentDto.getName());
        student.setFatherName(studentDto.getFatherName());
        student.setNumber(studentDto.getNumber());
        student.setBatch(studentDto.getBatch());
        student.setAge(studentDto.getAge());
        student.setPassOutYear(studentDto.getPassOutYear());
        student.setUpdatedOn(Instant.now());
        studentRepository.save(student);
    }

}
