package com.ayush.quiz_backend.repo;

import com.ayush.quiz_backend.entity.pythonQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PythonRepo extends JpaRepository<pythonQuestion,Long> {

}
