package ru.geekbrains.qa.java2.lesson7_project.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    private int age;
    private String name;

    @JsonCreator
    public Person(@JsonProperty("age") int age, @JsonProperty("firstName") String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
