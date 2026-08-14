package com.example.studentgraade;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id);
    }

    public Student register(Student student) {
        return studentRepository.save(student);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    public Student update(Long id, Student newInfo) {
        Student student = studentRepository.findById(id);
        student.setName(newInfo.getName());
        student.setScore(newInfo.getScore());
        return student;
    }

    public double getAverage(Long id) {
        Student student = studentRepository.findById(id);
        return calculateAverage(student);
    }

    public List<Student> findByMinScore(int minScore) {
        List<Student> result = new ArrayList<>();
        for (Student s : studentRepository.findAll()) {
            if (calculateAverage(s) >= minScore) {
                result.add(s);
            }
        }
        return result;
    }


    public List<Student> getRanking() {
        List<Student> all = studentRepository.findAll();
        for (int i = 0; i < all.size(); i++) {
            for (int j = 0; j < all.size() - 1 - i; j++) {
                if (calculateAverage(all.get(j)) < calculateAverage(all.get(j + 1))) {
                    Student temp = all.get(j);
                    all.set(j, all.get(j + 1));
                    all.set(j + 1, temp);
                }
            }
        }
        return all;
    }

    private double calculateAverage(Student student) {
        int sum = 0;
        for (int score : student.getScore()) {
            sum = sum + score;
        }
        return (double) sum / student.getScore().size();
    }
}