package com.example.examspring.Controller;

import com.example.examspring.ApiResponse.ApiResponse;
import com.example.examspring.Model.Teacher;
import com.example.examspring.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;


    //get


    @GetMapping("/get")
    public ResponseEntity getTeacher(){
         ArrayList<Teacher> teachers= teacherService.getTeachers();
        return ResponseEntity.status(200).body(teachers);
    }

    //add

    @PostMapping("/add")
    public ResponseEntity addTeacher(Teacher teacher){
        teacherService.addTeacher(teacher);
        return  ResponseEntity.status(200).body("teacher added");
    }

    //update

    @PostMapping("/update/{id}")
    public ResponseEntity updateTeacher(@Valid @RequestBody  @PathVariable int id, Teacher teacher, Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            ResponseEntity.status(400).body(new ApiResponse(message));
        }
        boolean isUpdated = teacherService.updateTeacher(id,teacher);
        if (isUpdated){
            return ResponseEntity.status(200).body("teacher updated");
        }
        return ResponseEntity.status(400).body("wrong id");
    }

    //delete

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable int id){

        boolean isDeleted = teacherService.deleteTeacher(id);
        if (isDeleted){
            return ResponseEntity.status(200).body("techer deleted");
        }
        return ResponseEntity.status(400).body("wrong id ");
    }

    //search teacher

    @PostMapping("/search/{id}")
    public  ResponseEntity searchTeacher(@Valid @PathVariable int id , Errors errors){

        if (errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        Teacher isTeacher= teacherService.searchTeacher(id);
        return ResponseEntity.status(200).body("search done");

    }
}
