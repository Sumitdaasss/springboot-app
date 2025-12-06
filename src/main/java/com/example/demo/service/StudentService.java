package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student saveStudent(Student s) {
        return repo.save(s);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudent(String id) {
        return repo.findById(id).orElse(null);
    }

    public Student updateStudent(String id, Student newData) {
        Student old = repo.findById(id).orElse(null);
        if (old != null) {
            old.setName(newData.getName());
            old.setEmail(newData.getEmail());
            return repo.save(old);
        }
        return null;
    }

    public String deleteStudent(String id) {
        repo.deleteById(id);
        return "Deleted Successfully!";
    }
}
