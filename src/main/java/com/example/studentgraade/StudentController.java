package com.example.studentgraade;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> findAll(@RequestParam(required = false)Integer minScore) {
        if (minScore == null) {
            return studentService.findAll();
        }
        return studentService.findByMinScore(minScore);
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PostMapping
    public Student register(@RequestBody Student student) {
        return studentService.register(student);
    }

    @PatchMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student newInfo) {
        return studentService.update(id, newInfo);
    }

    @DeleteMapping("/{id}")
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
