package com.ayush.quiz_backend.repo;

import com.ayush.quiz_backend.entity.JsQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JsRepo extends JpaRepository<JsQuestion,Long> {
}
