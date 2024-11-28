package com.ayush.quiz_backend.controller;

import com.ayush.quiz_backend.entity.Students;
import com.ayush.quiz_backend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

// Indicate that controller will return JSON rather than rendering a view
@RestController
@RequestMapping("api/student") // Base URL for all user-related endpoints
public class StudentController {

    private final StudentService service; // Use final for dependency injection

    @Autowired // Constructor-based injection
    public StudentController(StudentService service) {
        this.service = service;
    }
 
    @PostMapping("/create")
    public Students createStudent(@RequestBody Students student) {
        return service.createStudent(student);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Students student) {
        String email = student.getEmail();
        String password = student.getPassword();

        boolean isLoggedIn = service.login(email, password); // validate login credentials

        Map<String, String> response = new HashMap<>();
        if (isLoggedIn) {
            response.put("message", "Login successfully");
            return ResponseEntity.ok(response); // status 200 OK
        } else {
            response.put("message", "Invalid email or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response); // status 401 Unauthorized
        }
    }
}
