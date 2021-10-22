package ru.geekbrains.qa.java2.lesson7_project;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ru.geekbrains.qa.java2.lesson7_project.entity.Car;
import ru.geekbrains.qa.java2.lesson7_project.entity.Person;
import ru.geekbrains.qa.java2.lesson7_project.entity.Student;

import java.io.File;
import java.io.IOException;
import java.util.List;

/* Презентация работы с библиотекой Jackson */
public class Demo1 {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = new Student("Ivan", 4.87);
        String jsonStudent = objectMapper.writeValueAsString(student);
        System.out.println(jsonStudent);

    }

    private static void simpleWriteJsonToFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("yellow", "Renault Logan");
        objectMapper.writeValue(new File("car.json"), car);
    }

    private static void simpleWriteJsonAsString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        Car car = new Car("yellow", "Renault Logan");
        System.out.println(objectMapper.writeValueAsString(car));
    }

    private static void simpleReadJsonFromString() throws JsonProcessingException {
        String jsonString = "{ \"color\" : \"white\", \"type\" : \"Volga\" }";
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = objectMapper.readValue(jsonString, Car.class);
        System.out.println(car);
    }

    private static void readObjectWithUnknownProperties() throws com.fasterxml.jackson.core.JsonProcessingException {
        String jsonString = "{ \"color\" : \"white\", \"type\" : \"Volga\", \"year\" :\"1970\" }";
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = objectMapper.readValue(jsonString, Car.class);
        System.out.println(car);
    }

    private static void readValuesToList() throws com.fasterxml.jackson.core.JsonProcessingException {
        String carsList = "[{\"color\":\"red\", \"type\":\"BMW\"}," +
            " {\"color\":\"black\", \"type\":\"lada priora\"}]";
        ObjectMapper objectMapper = new ObjectMapper();
        List<Car> carList = objectMapper.readValue(carsList, new TypeReference<List<Car>>() {});
        System.out.println(carList);
    }

    private static void navigatingByJsonAsNodeTree() throws JsonProcessingException {
        String jsonString = "{\"name\":\"Ivan\", \"education\": " +
            "{\"school\": \"School #52\", \"university\": " +
            "{\"degree\": \"master\", \"name\": \"MGU\"}}}";

        //нагляднее в консоль
        System.out.println(jsonString);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode universityName = objectMapper.readTree(jsonString).at("/education/university/name");
        System.out.println(universityName.asText());
    }

    private static void useJsonCreatorAnnotation() throws JsonProcessingException {
        String jsonPerson = "{ \"age\" : 30, \"firstName\" : \"Vsevolod\" }";
        ObjectMapper objectMapper = new ObjectMapper();
        Person p = objectMapper.readValue(jsonPerson, Person.class);
        System.out.println(p);
    }
}


