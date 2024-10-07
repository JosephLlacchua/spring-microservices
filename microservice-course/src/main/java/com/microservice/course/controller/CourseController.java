package com.microservice.course.controller;

import com.microservice.course.entities.Course;
import com.microservice.course.services.ICourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/v1/courses")
public class CourseController {

    private final ICourseService courseService;

    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Course course = courseService.findById(id);
        return course != null ? ResponseEntity.ok(course) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public void save(@RequestBody Course course) {
        courseService.save(course);
    }


    @GetMapping("/students/{courseId}")
    public ResponseEntity<?> findStudentsByCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok(courseService.findStudentsByCourse(courseId));
    }


}
