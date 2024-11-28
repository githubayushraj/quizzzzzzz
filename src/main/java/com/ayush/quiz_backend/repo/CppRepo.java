package com.ayush.quiz_backend.repo;

import com.ayush.quiz_backend.entity.CppQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CppRepo extends JpaRepository<CppQuestion,Long> {
}
