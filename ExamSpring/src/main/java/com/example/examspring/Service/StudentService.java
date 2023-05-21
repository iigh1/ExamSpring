package com.example.examspring.Service;

import com.example.examspring.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    ArrayList<Student> students=new ArrayList<>();


    //get

    public ArrayList<Student> getStudents() {
        return students;
    }

    //add

    public void addStudent(Student student){
        students.add(student);
    }

    //update

    public boolean updateStudent(int id, Student student){

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getId()==id){
                students.set(i,student);
                return true;
            }
        }
        return false;
    }

    //delete

    public boolean deleteStudent(int id ){

        for (int i = 0; i < students.size() ; i++) {

            if (students.get(i).getId()==id){
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    //search student
    public Student searchStudent(String name){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name)){
                return students.get(i);
            }
        }
        return null;
    }


}
