package ru.geekbrains.qa.java2.lesson7_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "car")
public class Car {
    private String color;

    private String type;

//    @JsonProperty(value = "model")
//    private String type;

    @JsonIgnore
    private boolean isActive;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Car(String color, String type) {
        this.color = color;
        this.type = type;
    }

    // Показать студентам поведение при десериализации в класс без конструктора по умолчанию
    public Car() {

    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
