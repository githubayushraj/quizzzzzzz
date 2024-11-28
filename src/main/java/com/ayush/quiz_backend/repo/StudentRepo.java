package com.ayush.quiz_backend.repo;


import com.ayush.quiz_backend.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//@Repository is an annotation used to tell Spring that this class or interface
// will handle data storage and retrieval operations.
public interface StudentRepo extends JpaRepository<Students,Integer> {

    // custom query method
    Students findByEmail(String email);
}
