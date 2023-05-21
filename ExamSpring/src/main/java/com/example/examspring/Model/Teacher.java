package com.example.examspring.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Teacher {

    @NotNull(message = "id cannot be empty")
    private int id;
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @NotNull(message = "salary cannot be empty")
    private double salary;

}
