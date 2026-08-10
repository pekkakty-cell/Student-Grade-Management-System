package com.example.studentgraade;

import java.util.List;

import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @GetMapping
    public List<Student> findByMinScore(@RequestParam int minScore) {
        return studentService.findByMinScore(minScore);
    }

    @PostMapping
    public Student register(@RequestBody Student student) {
        return studentService.register(student);
    }

    @PatchMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student newInfo) {
        return studentService.update(id, newInfo);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }

    @GetMapping("/{id}/average")
    public double getAverage(@PathVariable Long id) {
        return studentService.getAverage(id);
    }
    @GetMapping("/rank")
    public List<Student> getRanking() {
        return studentService.getRanking();
    }
}
