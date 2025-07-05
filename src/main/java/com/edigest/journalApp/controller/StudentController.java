package com.edigest.journalApp.controller;

import com.edigest.journalApp.model.Student;
import com.edigest.journalApp.service.OllamaService;
import com.edigest.journalApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final OllamaService ollamaService;

    @Autowired
    public StudentController(StudentService studentService, OllamaService ollamaService) {
        this.studentService = studentService;
        this.ollamaService = ollamaService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/{id}/summary")
    public String getStudentSummary(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        return ollamaService.generateStudentSummary(student);
    }
}
