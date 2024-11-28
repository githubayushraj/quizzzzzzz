package com.ayush.quiz_backend.repo;

import com.ayush.quiz_backend.entity.DevOpsQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevopsRepo extends JpaRepository<DevOpsQuestion,Long> {
}
