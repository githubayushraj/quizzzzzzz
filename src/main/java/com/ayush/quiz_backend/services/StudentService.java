package com.ayush.quiz_backend.services;

import com.ayush.quiz_backend.entity.Students;
import com.ayush.quiz_backend.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepo repo; // Change name to repo for clarity

    @Autowired // Constructor-based injection
    public StudentService(StudentRepo repo) {
        this.repo = repo;
    }

    public Students createStudent(Students student) {
        return repo.save(student); // Use repo to save student
    }

    public boolean login(String email, String password) {
        if (email == null || password == null) {
            throw new IllegalArgumentException("Email and password cannot be null");
        }
        Students student = repo.findByEmail(email);
        return student != null && student.getPassword().equals(password);
    }
}
