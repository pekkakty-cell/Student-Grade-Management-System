package com.example.studentgraade;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private List<Student> students = new ArrayList<>();
    private Long nextId = 1L;
    //  1 증가

    public List<Student> findAll(){
        return students;
    }

    public Student findById(Long id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public Student save(Student student) {
        student.setId(nextId++);
        students.add(student);
        return student;
    }

    public void deleteById(Long id) {
        Student target = null;
        for (Student s : students) {
            if (s.getId().equals(id)) {
                target = s;
            }
        }
        if (target != null) {
            students.remove(target);
        }
    }
}
