package com.programming.packetPrep.springngStudent.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @NotBlank
    @Column
    private String studentName;
    @NotBlank
    @Column
    private String fatherName;



    @NotNull
    @Column
    private Long number;
    @NotBlank
    @Column
    private String batch;
    @NotBlank
    @Column
    private String name;
    @NotNull
    @Column
    private Integer age;
    @NotNull
    @Column
    private Integer passOutYear;
    @Lob
    @NotBlank
    @Column
    @NotEmpty
    private String studentEmail;
    @Column
    private Instant createdOn;
    @Column
    private Instant updatedOn;
    @Column
    private String password;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Instant getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Instant updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getAge() {
        return age;
    }

    public Integer getPassOutYear() {
        return passOutYear;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPassOutYear(Integer passOutYear) {
        this.passOutYear = passOutYear;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





}
