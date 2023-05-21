package com.example.examspring.Service;

import com.example.examspring.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<Teacher> teachers=new ArrayList<>();

    // get teachers
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    //add teacher
    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    //update teacher

    public boolean updateTeacher(int id , Teacher teacher){
        for (int i = 0; i <teachers.size() ; i++) {

            if (teachers.get(i).getId()==id){
                teachers.set(i,teacher);
                return true;
            }
        }
        return false;
    }

    //delete teacher
    public boolean deleteTeacher(int id){
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId()==id){
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }

    //search teacher
    public Teacher searchTeacher(int id){
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId()==id){

                return searchTeacher(id);
            }
        }
        return null;
    }
}
