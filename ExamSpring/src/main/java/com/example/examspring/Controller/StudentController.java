package com.example.examspring.Controller;


import com.example.examspring.ApiResponse.ApiResponse;
import com.example.examspring.Model.Student;
import com.example.examspring.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    //get

    @GetMapping("/get")
    public ResponseEntity getStudent(){
        ArrayList<Student> students=studentService.getStudents();
        return ResponseEntity.status(200).body(students);
    }

    //add

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student, Errors errors){

        if (errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("added");
    }

    //update

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@Valid @RequestBody Student student, Errors errors,@PathVariable int id ){

        if (errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }

        boolean isUpdated =studentService.updateStudent(id,student);

        if (isUpdated){
            return ResponseEntity.status(200).body("student updated");
        }
        return ResponseEntity.status(400).body("wrong id");
    }

    //delete

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id){

        boolean isDeleted = studentService.deleteStudent(id);

        if(isDeleted){
            return ResponseEntity.status(200).body("student deleted");
        }
        return ResponseEntity.status(400).body("wrong id");
    }

    //search student

    @PutMapping("/search/{name}")
    public ResponseEntity searchStudent(@Valid @RequestBody String name, Errors errors){

        if (errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        Student isStudent = studentService.searchStudent(name);
        return ResponseEntity.status(200).body("search done");

    }
}
