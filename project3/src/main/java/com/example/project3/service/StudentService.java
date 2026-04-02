package com.example.project3.service;

import com.example.project3.dto.CreateStudentRequest;
import com.example.project3.dto.UpdateStudentRequest;
import com.example.project3.exception.DuplicateResourceException;
import com.example.project3.exception.ResourceNotFoundException;
import com.example.project3.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();
    private Long nextid = 1L;

    public List<Student> findAll(){
        return students;
    }

    public Student create(CreateStudentRequest request){
        boolean studentCodeExists = students.stream()
                .anyMatch(s -> s.getStudentCode().equals(request.getStudentCode()));
        if(studentCodeExists){
            throw new DuplicateResourceException("Student", "studentCode", request.getStudentCode());
        }
        boolean emailExists = students.stream()
                .anyMatch(s -> s.getEmail().equals(request.getEmail()));
        if(emailExists){
            throw new DuplicateResourceException("Email", "email", request.getEmail());
    }
        Student student = new Student();
        student.setId(nextid++);
        student.setStudentCode(request.getStudentCode());
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setPhone(request.getPhone());
        student.setDateOfBirth(request.getDateOfBirth());
        student.setGpa(request.getGpa());
        student.setMajor(request.getMajor());
        student.setYear(request.getYear());

        students.add(student);
        return student;
    }

    public Student findById(Long id){
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
    }

    public Student updateById(Long id, UpdateStudentRequest request){
        Student student = findById(id);

        student.setName(request.getName());
        student.setEmail(request.getEmail());
        boolean emailExists = students.stream()
                .anyMatch(s -> s.getEmail().equals(request.getEmail()) && !s.getId().equals(id));
        if(emailExists){
            throw new DuplicateResourceException("Student", "email", request.getEmail());
        }
        student.setPhone(request.getPhone());
        student.setDateOfBirth(request.getDateOfBirth());
        student.setGpa(request.getGpa());
        student.setMajor(request.getMajor());
        student.setYear(request.getYear());

        return student;
    }

    public void deleteById(Long id){
        Student student = findById(id);
        students.remove(student);
}

    public List<Student> getStudentsByMajor(String major){
        return students.stream()
                .filter(s -> s.getMajor().equalsIgnoreCase(major))
                .toList();
    }

    public List<Student> getHonorStudents(){
        return students.stream()
                .filter(s -> s.getGpa() >= 3.6)
                .toList();
    }



}
