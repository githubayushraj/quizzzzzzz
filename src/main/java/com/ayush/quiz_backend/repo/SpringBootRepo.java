package com.ayush.quiz_backend.repo;

import com.ayush.quiz_backend.entity.SpringBootQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringBootRepo extends JpaRepository<SpringBootQuestion,Long> {
}
