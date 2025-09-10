package com.example.elearning.controller;

import com.example.elearning.model.Course;
import com.example.elearning.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepo;

    @GetMapping
    public List<Course> all() {
        return courseRepo.findAll();
    }

    @PostMapping
    public Course create(@RequestBody Course c) {
        return courseRepo.save(c);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> get(@PathVariable Long id) {
        return courseRepo.findById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
