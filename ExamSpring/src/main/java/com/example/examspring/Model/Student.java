package com.example.examspring.Model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {


    @NotNull(message = "id cannot be empty")
    private int id;
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @NotNull(message = "age cannot be empty")
    private int age;
    @NotEmpty(message = "major cannot be empty")
    private String major;
}
