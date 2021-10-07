package com.programming.techie.springngblog.controller;



import com.programming.techie.springngblog.dto.StudentDto;
import com.programming.techie.springngblog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity createStudent(@RequestBody StudentDto studentDto) {
        studentService.createStudent(studentDto);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity updateStudent(@RequestBody StudentDto studentDto) {
        studentService.updateStudent(studentDto);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<StudentDto>> showAllStudent() {
        return new ResponseEntity<>(studentService.showAllStudent(), HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<StudentDto> getSingleStudent(@PathVariable @RequestBody Long id) {
        return new ResponseEntity<>(studentService.readSingleStudent(id), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable @RequestBody Long id) {
        return (studentService.deleteStudent(id));
    }
}
