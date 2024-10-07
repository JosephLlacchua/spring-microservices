package com.microservice.student.controller;


import com.microservice.student.entities.Student;
import com.microservice.student.services.IStudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        Student student = studentService.findById(id);
        return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public void save(@RequestBody Student student) {
        studentService.save(student);
    }

    @GetMapping("/course/{courseId}")
    public List<Student> findByCourseId(@PathVariable Long courseId) {
        return studentService.findByCourseId(courseId);
    }


}
