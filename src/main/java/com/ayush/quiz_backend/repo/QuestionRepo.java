package com.ayush.quiz_backend.repo;

import com.ayush.quiz_backend.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question,Long> {
}
