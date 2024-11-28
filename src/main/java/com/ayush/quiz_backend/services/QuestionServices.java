package com.ayush.quiz_backend.services;

import com.ayush.quiz_backend.entity.*;
import com.ayush.quiz_backend.repo.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class QuestionServices {

    private final QuestionRepo questionRepo;
    private final PythonRepo pythonRepo;
    private final JsRepo jsRepo;
    private final CppRepo cppRepo;
    private final DevopsRepo devopsRepo;
    private final SpringBootRepo springBootRepo;

    @Autowired
    public QuestionServices(QuestionRepo questionRepo, PythonRepo pythonRepo,JsRepo jsRepo, CppRepo cppRepo, DevopsRepo devopsRepo, SpringBootRepo springBootRepo) {
        this.questionRepo = questionRepo;
        this.pythonRepo = pythonRepo;
        this.jsRepo = jsRepo;
        this.cppRepo = cppRepo;
        this.devopsRepo = devopsRepo;
        this.springBootRepo = springBootRepo;
    }



    @PostConstruct
    public void init() {
        if(questionRepo.count()==0){
            List<Question> questions = Arrays.asList(
                    new Question(null, "What is the size of `int` in Java?", "4 bytes", Arrays.asList("2 bytes", "4 bytes", "8 bytes", "16 bytes")),
                    new Question(null, "Which of the following is a valid access modifier in Java?", "private", Arrays.asList("private", "invisible", "secure", "definite")),
                    new Question(null, "What is the default value of a boolean variable in Java?", "false", Arrays.asList("true", "false", "null", "0")),
                    new Question(null, "Which method is used to start a thread in Java?", "start()", Arrays.asList("run()", "execute()", "start()", "initialize()")),
                    new Question(null, "Which of these is not a primitive data type in Java?", "String", Arrays.asList("int", "boolean", "char", "String")),
                    new Question(null, "What is the wrapper class for `int` in Java?", "Integer", Arrays.asList("Int", "Integer", "IntWrapper", "IntegerWrapper")),
                    new Question(null, "Which of the following is used to handle exceptions in Java?", "try-catch", Arrays.asList("if-else", "try-catch", "throw-throws", "assert")),
                    new Question(null, "Which collection class does not allow duplicate elements?", "Set", Arrays.asList("List", "Set", "Queue", "Map")),
                    new Question(null, "What does JVM stand for?", "Java Virtual Machine", Arrays.asList("Java Variable Machine", "Java Virtual Memory", "Java Virtual Machine", "Java Version Machine")),
                    new Question(null, "Which of the following is a superclass of all classes in Java?", "Object", Arrays.asList("String", "Object", "Class", "Serializable"))
            );

            questionRepo.saveAll(questions);
        }

        if (pythonRepo.count() == 0) {
            List<pythonQuestion> pythonQuestions = Arrays.asList(
                    new pythonQuestion(null, "What is the correct file extension for Python files?", ".py", Arrays.asList(".python", ".py", ".pt", ".p")),
                    new pythonQuestion(null, "Which keyword is used to define a function in Python?", "def", Arrays.asList("function", "define", "def", "fn")),
                    new pythonQuestion(null, "Which of these is not a valid data type in Python?", "character", Arrays.asList("int", "float", "list", "character")),
                    new pythonQuestion(null, "Which Python library is used for data manipulation?", "Pandas", Arrays.asList("Numpy", "Matplotlib", "Pandas", "Scipy")),
                    new pythonQuestion(null, "What is the output of `print(2 ** 3)`?", "8", Arrays.asList("6", "8", "9", "16")),
                    new pythonQuestion(null, "Which statement is used to handle exceptions in Python?", "try-except", Arrays.asList("try-catch", "try-except", "if-else", "catch-finally")),
                    new pythonQuestion(null, "What is the default value of `len([])` in Python?", "0", Arrays.asList("1", "0", "None", "Undefined")),
                    new pythonQuestion(null, "How do you start a comment in Python?", "#", Arrays.asList("//", "#", "--", "/*")),
                    new pythonQuestion(null, "Which method is used to add an element to a list in Python?", "append()", Arrays.asList("add()", "append()", "insert()", "extend()")),
                    new pythonQuestion(null, "What is the output of `type(3.14)` in Python?", "<class 'float'>", Arrays.asList("<class 'float'>", "<class 'int'>", "<class 'double'>", "<class 'number'>")),
                    new pythonQuestion(null, "Which keyword is used to create a class in Python?", "class", Arrays.asList("object", "class", "def", "type")),
                    new pythonQuestion(null, "Which function is used to read input from the user in Python?", "input()", Arrays.asList("scan()", "cin()", "read()", "input()")),
                    new pythonQuestion(null, "What does `len()` function do in Python?", "Returns the length of an object", Arrays.asList("Checks data type", "Returns the length of an object", "Converts string to int", "Calculates sum")),
                    new pythonQuestion(null, "Which of these is a valid Python loop?", "for", Arrays.asList("foreach", "loop", "for", "iterate")),
                    new pythonQuestion(null, "How do you import a module in Python?", "import module_name", Arrays.asList("module import", "import module_name", "include module_name", "load module_name"))
            );
            pythonRepo.saveAll(pythonQuestions);
        }

        if(jsRepo.count()==0){
            List<JsQuestion> jsQuestions = Arrays.asList(
                    new JsQuestion(null, "Which company developed JavaScript?", "Netscape", Arrays.asList("Microsoft", "Netscape", "Google", "IBM")),
                    new JsQuestion(null, "Which of the following is a JavaScript data type?", "String", Arrays.asList("Float", "Integer", "String", "Character")),
                    new JsQuestion(null, "Which symbol is used for comments in JavaScript?", "//", Arrays.asList("//", "/*", "#", "<!--")),
                    new JsQuestion(null, "How do you declare a variable in JavaScript?", "var", Arrays.asList("variable", "declare", "var", "let")),
                    new JsQuestion(null, "What does `typeof null` return in JavaScript?", "object", Arrays.asList("null", "undefined", "object", "string")),
                    new JsQuestion(null, "Which method is used to parse a string to an integer in JavaScript?", "parseInt()", Arrays.asList("parse()", "int()", "parseInt()", "toInt()")),
                    new JsQuestion(null, "What is the correct syntax for creating a function in JavaScript?", "function myFunction() {}", Arrays.asList("def myFunction() {}", "function: myFunction() {}", "function myFunction() {}", "create myFunction() {}")),
                    new JsQuestion(null, "What is the output of `console.log(typeof NaN);`?", "number", Arrays.asList("NaN", "undefined", "number", "string")),
                    new JsQuestion(null, "Which object is the parent of all objects in JavaScript?", "Object", Arrays.asList("Window", "Global", "Object", "Document")),
                    new JsQuestion(null, "How do you write an `if` statement in JavaScript?", "if (condition) {}", Arrays.asList("if condition {}", "if (condition) {}", "if: condition {}", "if {condition}")),
                    new JsQuestion(null, "What does `isNaN()` do in JavaScript?", "Checks if a value is not a number", Arrays.asList("Checks if a value is null", "Checks if a value is NaN", "Checks if a value is not a number", "Checks if a value is zero")),
                    new JsQuestion(null, "Which event occurs when a user clicks on an HTML element?", "onclick", Arrays.asList("onmouseclick", "onclick", "onhover", "onpress")),
                    new JsQuestion(null, "What will `console.log(2 + '2')` output?", "22", Arrays.asList("22", "4", "Error", "undefined")),
                    new JsQuestion(null, "Which of the following is not a looping structure in JavaScript?", "foreach", Arrays.asList("for", "while", "foreach", "do-while")),
                    new JsQuestion(null, "What does `===` mean in JavaScript?", "Strict equality", Arrays.asList("Loose equality", "Strict equality", "Assignment", "Comparison"))
            );
            jsRepo.saveAll(jsQuestions);
        }


        if(cppRepo.count()==0){
            List<CppQuestion> cppQuestions = Arrays.asList(
                    new CppQuestion(null, "Which of the following is the correct file extension for C++ files?", ".cpp", Arrays.asList(".cpp", ".cp", ".cplus", ".cc")),
                    new CppQuestion(null, "Which operator is used to access a member function of a class in C++?", ".", Arrays.asList(".", "->", "::", "[]")),
                    new CppQuestion(null, "What is the default access specifier for class members in C++?", "private", Arrays.asList("public", "private", "protected", "none")),
                    new CppQuestion(null, "Which of these is not a C++ keyword?", "include", Arrays.asList("class", "include", "virtual", "namespace")),
                    new CppQuestion(null, "Which data type is used to create a variable that stores text in C++?", "string", Arrays.asList("char", "string", "text", "word")),
                    new CppQuestion(null, "What does the `new` keyword do in C++?", "Allocates memory dynamically", Arrays.asList("Deletes an object", "Creates a new class", "Allocates memory dynamically", "None of the above")),
                    new CppQuestion(null, "Which header file is used for input/output operations in C++?", "iostream", Arrays.asList("stdio.h", "stdlib.h", "iostream", "fileio.h")),
                    new CppQuestion(null, "What is the output of `cout << (5 / 2);` in C++?", "2", Arrays.asList("2", "2.5", "Error", "Undefined")),
                    new CppQuestion(null, "Which of the following is not a feature of C++?", "Garbage Collection", Arrays.asList("Inheritance", "Polymorphism", "Encapsulation", "Garbage Collection")),
                    new CppQuestion(null, "What is the size of a `bool` data type in C++?", "1 byte", Arrays.asList("1 byte", "2 bytes", "4 bytes", "8 bytes")),
                    new CppQuestion(null, "Which of these is a valid loop construct in C++?", "for", Arrays.asList("for", "foreach", "repeat", "loop")),
                    new CppQuestion(null, "What does the `return` statement do in a function?", "Exits the function and optionally returns a value", Arrays.asList("Exits the program", "Restarts the function", "Exits the function and optionally returns a value", "None of the above")),
                    new CppQuestion(null, "Which of these is a valid pointer declaration in C++?", "int* ptr;", Arrays.asList("int ptr*;", "int* ptr;", "int& ptr;", "int ptr&;")),
                    new CppQuestion(null, "Which keyword is used to define a constant in C++?", "const", Arrays.asList("constant", "define", "const", "static")),
                    new CppQuestion(null, "What is the purpose of the `virtual` keyword in C++?", "Enable runtime polymorphism", Arrays.asList("Declare a static member", "Enable runtime polymorphism", "Create an abstract class", "Define a default constructor"))
            );
            cppRepo.saveAll(cppQuestions);
        }

        if (devopsRepo.count() == 0) {
            List<DevOpsQuestion> devOpsQuestions = Arrays.asList(
                    new DevOpsQuestion(null, "Which tool is primarily used for containerization?", "Docker", Arrays.asList("Docker", "Jenkins", "Kubernetes", "Git")),
                    new DevOpsQuestion(null, "Which tool is used for continuous integration?", "Jenkins", Arrays.asList("Docker", "Terraform", "Jenkins", "Ansible")),
                    new DevOpsQuestion(null, "What is the purpose of version control systems like Git?", "Tracking changes in source code", Arrays.asList("Deploying applications", "Managing servers", "Tracking changes in source code", "Monitoring infrastructure")),
                    new DevOpsQuestion(null, "Which command is used to check the status of a Git repository?", "git status", Arrays.asList("git status", "git log", "git check", "git init")),
                    new DevOpsQuestion(null, "Which of these is an infrastructure as code tool?", "Terraform", Arrays.asList("Terraform", "Kubernetes", "Docker", "Nagios")),
                    new DevOpsQuestion(null, "What does CI/CD stand for?", "Continuous Integration/Continuous Deployment", Arrays.asList("Continuous Integration/Continuous Deployment", "Code Integration/Code Deployment", "Container Infrastructure/Container Development", "Continuous Infrastructure/Continuous Delivery")),
                    new DevOpsQuestion(null, "Which tool is used for container orchestration?", "Kubernetes", Arrays.asList("Ansible", "Kubernetes", "Chef", "Docker")),
                    new DevOpsQuestion(null, "What is the purpose of monitoring tools like Prometheus?", "Tracking system metrics and performance", Arrays.asList("Deploying containers", "Automating tests", "Tracking system metrics and performance", "Managing infrastructure as code")),
                    new DevOpsQuestion(null, "Which command is used to create a new branch in Git?", "git branch <branch_name>", Arrays.asList("git branch <branch_name>", "git create branch", "git new branch", "git init branch")),
                    new DevOpsQuestion(null, "Which tool helps automate configuration management?", "Ansible", Arrays.asList("Kubernetes", "Jenkins", "Docker", "Ansible")),
                    new DevOpsQuestion(null, "Which tool is used to build, test, and deploy applications in pipelines?", "Jenkins", Arrays.asList("Git", "Docker", "Jenkins", "Chef")),
                    new DevOpsQuestion(null, "What is the purpose of a load balancer in DevOps?", "Distribute network traffic across servers", Arrays.asList("Build Docker containers", "Automate deployments", "Distribute network traffic across servers", "Monitor system performance")),
                    new DevOpsQuestion(null, "Which command is used to commit changes in Git?", "git commit -m", Arrays.asList("git push", "git commit -m", "git add", "git merge")),
                    new DevOpsQuestion(null, "Which tool is used for infrastructure monitoring?", "Nagios", Arrays.asList("Nagios", "Jenkins", "Kubernetes", "Terraform")),
                    new DevOpsQuestion(null, "What is a primary use case for Helm in Kubernetes?", "Managing Kubernetes applications", Arrays.asList("Building containers", "Managing Kubernetes applications", "Monitoring logs", "Automating CI/CD"))
            );
            devopsRepo.saveAll(devOpsQuestions);
        }

        if (springBootRepo.count() == 0) {
            List<SpringBootQuestion> springBootQuestions = Arrays.asList(
                    new SpringBootQuestion(null, "What is Spring Boot?",
                            "A framework for building microservices",
                            Arrays.asList("A dependency management tool", "A framework for building microservices", "A database ORM tool", "A Java compiler")),
                    new SpringBootQuestion(null, "Which annotation is used to mark a Spring Boot application class?",
                            "@SpringBootApplication",
                            Arrays.asList("@SpringApplication", "@SpringBootApp", "@SpringBootApplication", "@ApplicationBoot")),
                    new SpringBootQuestion(null, "Which file is used to configure properties in a Spring Boot application?",
                            "application.properties",
                            Arrays.asList("config.yaml", "application.properties", "settings.xml", "spring.properties")),
                    new SpringBootQuestion(null, "What is the default embedded server in Spring Boot?",
                            "Tomcat",
                            Arrays.asList("Jetty", "Tomcat", "Undertow", "Netty")),
                    new SpringBootQuestion(null, "Which annotation is used to create a REST controller in Spring Boot?",
                            "@RestController",
                            Arrays.asList("@Controller", "@RestController", "@RequestMapping", "@ResponseBody")),
                    new SpringBootQuestion(null, "Which dependency is required for a Spring Boot application to work?",
                            "spring-boot-starter",
                            Arrays.asList("spring-context", "spring-orm", "spring-boot-starter", "spring-core")),
                    new SpringBootQuestion(null, "Which annotation is used to map HTTP requests to a specific method?",
                            "@RequestMapping",
                            Arrays.asList("@GetMapping", "@RequestMapping", "@PostMapping", "@Mapping")),
                    new SpringBootQuestion(null, "What is the purpose of Spring Boot Starter dependencies?",
                            "To simplify adding dependencies to the project",
                            Arrays.asList("To configure the database", "To monitor application performance", "To simplify adding dependencies to the project", "To manage application security")),
                    new SpringBootQuestion(null, "Which annotation is used to handle exceptions in Spring Boot?",
                            "@ExceptionHandler",
                            Arrays.asList("@ErrorHandler", "@ExceptionMapper", "@ExceptionHandler", "@ErrorMapping")),
                    new SpringBootQuestion(null, "What is the purpose of the `application.yml` file in Spring Boot?",
                            "To configure application properties",
                            Arrays.asList("To write application code", "To manage application dependencies", "To configure application properties", "To handle database migrations")),
                    new SpringBootQuestion(null, "Which Spring Boot feature enables monitoring and management of the application?",
                            "Spring Boot Actuator",
                            Arrays.asList("Spring Boot CLI", "Spring Boot DevTools", "Spring Boot Actuator", "Spring Boot Security")),
                    new SpringBootQuestion(null, "Which annotation is used for dependency injection in Spring Boot?",
                            "@Autowired",
                            Arrays.asList("@Inject", "@Resource", "@Autowired", "@Qualifier")),
                    new SpringBootQuestion(null, "Which starter is used for connecting to an SQL database?",
                            "spring-boot-starter-data-jpa",
                            Arrays.asList("spring-boot-starter-data-jpa", "spring-boot-starter-web", "spring-boot-starter-security", "spring-boot-starter-orm")),
                    new SpringBootQuestion(null, "Which annotation enables scheduling tasks in Spring Boot?",
                            "@EnableScheduling",
                            Arrays.asList("@EnableTasks", "@EnableScheduling", "@ScheduledTasks", "@EnableTimer")),
                    new SpringBootQuestion(null, "How do you run a Spring Boot application from the command line?",
                            "Run the main method of the application class",
                            Arrays.asList("Run the jar file using `java -jar`", "Run the main method of the application class", "Compile and run the class files manually", "Start the embedded server first"))
            );
            springBootRepo.saveAll(springBootQuestions);
        }


    }




    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }

    public List<pythonQuestion> getAllPythonQuestions() {
        return pythonRepo.findAll();
    }

    public List<CppQuestion> getAllCppQuestions() {
        return cppRepo.findAll();
    }

    public List<JsQuestion> getAllJsQuestion(){
        return jsRepo.findAll();
    }

    public List<DevOpsQuestion> getAllDevOpsQuestion(){
        return devopsRepo.findAll();
    }

    public List<SpringBootQuestion> getAllSpringBootQuestion(){
        return springBootRepo.findAll();
    }
}
