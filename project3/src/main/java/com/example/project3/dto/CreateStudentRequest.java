package com.example.project3.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class CreateStudentRequest {

    @Pattern(regexp = "^SV\\d{3}$", message = "studentCode phai co dang SVxxx (vd: SV001)")
    private String studentCode;

    @NotBlank(message = "name khong duoc de trong")
    private String name;

    @NotBlank(message = "email khong duoc de trong")
    @Email(message = "email phai dung dinh dang")
    private String email;

    @Pattern(regexp = "^0\\d{9}$", message = "phone phai co 10 chu so va bat dau bang 0")
    private String phone;

    @NotNull(message = "Ngay sinh khong duoc de trong")
    @Past(message = "Ngay sinh phai o qua khu")
    private LocalDate dateOfBirth;

    @DecimalMin(value = "0.0", message = "GPA >= 0.0")
    @DecimalMax(value = "4.0", message = "GPA <= 4")
    private Double gpa;

    @NotBlank(message = "major khong duoc de trong")
    private String major;

    @NotNull(message = "Nam khong duoc de trong")
    @Min(value = 1, message = "year >= 1")
    @Max(value = 6, message = "year <= 6")
    private Integer year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
