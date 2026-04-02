package com.example.project3.controller;


import com.example.project3.dto.CreateStudentRequest;
import com.example.project3.dto.UpdateStudentRequest;
import com.example.project3.model.Student;
import com.example.project3.response.ApiResponse;
import com.example.project3.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents() {
        return ResponseEntity.ok(ApiResponse.success(studentService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(studentService.findById(id)));
}

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> createStudent(
            @Valid @RequestBody CreateStudentRequest request) {
        Student student = studentService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.created(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody UpdateStudentRequest request) {
        Student student = studentService.updateById(id, request);
        return ResponseEntity.ok(ApiResponse.success(student));
}

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteStudent(@PathVariable Long id) {
        studentService.deleteById(id);
        return ResponseEntity.ok(ApiResponse.success("Xoa sinh vien thanh cong"));
    }

    @GetMapping("major/{major}")
    public ResponseEntity<ApiResponse<List<Student>>> findByMajor(@PathVariable String major) {
        List<Student> students = studentService.getStudentsByMajor(major);
        return ResponseEntity.ok(ApiResponse.success(students));
    }

    @GetMapping("/honor")
    public ResponseEntity<ApiResponse<List<Student>>> findHonorStudents() {
        List<Student> students = studentService.getHonorStudents();
        return ResponseEntity.ok(ApiResponse.success(students));
    }

}
