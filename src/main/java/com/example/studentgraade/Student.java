package com.example.studentgraade;

import java.util.List;
// java.util 안에 있는 list를 가져다 쓰겠다고 선언

public class Student {

    private Long id;
    private String name;
    private List<Integer> score;

    public Student() {

    }
    // 빈 생성자: 아무 값 없이 학생 객체만 먼저 만들고,
    // 나중에 setter로 값을 채우고 싶을 때 사용합니다.

    public Student(Long id, String name, List<Integer>scores) {
        this.id = id;
        this.name = name;
        this.score = scores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getScore() {
        return score;
    }

    public void setScore(List<Integer> scores) {
        this.score = scores;
    }
}
