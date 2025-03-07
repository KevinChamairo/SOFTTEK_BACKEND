package com.kacr.back.backend_softtek.controller;

import com.kacr.back.backend_softtek.entity.studentEntity;
import com.kacr.back.backend_softtek.services.studentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:4200")
public class studentController {
    private final studentService studentService;

    @Autowired
    public studentController(studentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/addStudent")
    public ResponseEntity<studentEntity> addStudent(@RequestBody studentEntity student) {
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @PostMapping("/addStudents")
    public ResponseEntity<List<studentEntity>> addStudents(@RequestBody List<studentEntity> students) {
        return ResponseEntity.ok(studentService.createStudents(students));
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Optional<studentEntity>> getStudentById(@PathVariable int id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping("/students")
    public ResponseEntity<List<studentEntity>> getAllStudents() {
        return ResponseEntity.ok(studentService.getStudents());
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<studentEntity> updateStudent(@RequestBody studentEntity student) {
        return ResponseEntity.ok(studentService.updateStudent(student));
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        return ResponseEntity.ok(studentService.deleteStudentById(id));
    }
}