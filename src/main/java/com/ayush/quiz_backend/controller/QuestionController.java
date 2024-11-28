package com.ayush.quiz_backend.controller;

import com.ayush.quiz_backend.entity.*;
import com.ayush.quiz_backend.services.QuestionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class QuestionController {
    private final QuestionServices services;

    @Autowired
    public QuestionController(QuestionServices services){
        this.services = services;
    }

    @GetMapping("/java")
    public List<Question> getQuestions(){
        return services.getAllQuestions();
    }

    @GetMapping("/python")
    public List<pythonQuestion> getPythonQuestions(){
        return services.getAllPythonQuestions();
    }

    @GetMapping("/cpp")
    public List<CppQuestion> getCppQuestions(){
        return services.getAllCppQuestions();
    }

    @GetMapping("/js")
    public List<JsQuestion> getJsQuestion(){
        return services.getAllJsQuestion();
    }

    @GetMapping("/devops")
    public List<DevOpsQuestion> getDevOpsQuestion(){
        return services.getAllDevOpsQuestion();
    }

    @GetMapping("/spring")
    public List<SpringBootQuestion> getSpringBootQuestion(){
        return services.getAllSpringBootQuestion();
    }

}
