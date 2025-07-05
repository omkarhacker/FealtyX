package com.edigest.journalApp.service;

import com.edigest.journalApp.exception.StudentNotFoundException;
import com.edigest.journalApp.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentService {
    private final ConcurrentHashMap<Integer, Student> students = new ConcurrentHashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public Student getStudentById(int id) {
        Student student = students.get(id);
        if (student == null) {
            throw new StudentNotFoundException("Student with ID " + id + " not found");
        }
        return student;
    }

    public Student createStudent(Student student) {
        validateStudent(student);
        int id = idCounter.getAndIncrement();
        student.setId(id);
        students.put(id, student);
        return student;
    }

    public Student updateStudent(int id, Student student) {
        if (!students.containsKey(id)) {
            throw new StudentNotFoundException("Student with ID " + id + " not found");
        }
        validateStudent(student);
        student.setId(id);
        students.put(id, student);
        return student;
    }

    public void deleteStudent(int id) {
        if (!students.containsKey(id)) {
            throw new StudentNotFoundException("Student with ID " + id + " not found");
        }
        students.remove(id);
    }

    private void validateStudent(Student student) {
        if (student.getName() == null || student.getName().isEmpty()) {
            throw new IllegalArgumentException("Student name is required");
        }
        if (student.getAge() <= 0) {
            throw new IllegalArgumentException("Student age must be positive");
        }
        if (student.getEmail() == null || student.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Student email is required");
        }
    }
}