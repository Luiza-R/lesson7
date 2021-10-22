package ru.geekbrains.qa.java2.lesson7_project.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Student {
    private String name;
    private double averageMark;

    @JsonGetter("name")
    public String getStudentName() {
        return name;
    }

    @JsonSetter("name")
    public void setStudentName(String name) {
        this.name = name;
    }

    @JsonGetter("averageMark")
    public double getAvgMark() {
        return averageMark;
    }

    @JsonSetter("averageMark")
    public void setAvgMark(double averageMark) {
        this.averageMark = averageMark;
    }

    public Student(String name, double averageMark) {
        this.name = name;
        this.averageMark = averageMark;
    }

    public Student() {

    }
}
