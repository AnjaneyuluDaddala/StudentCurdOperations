package com.springcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcore.model.StudentModel;

@RestController
@RequestMapping("/students")
public class NewController {
	



    private final List<StudentModel> students = new ArrayList<>();

    @GetMapping("/{id}")
    public StudentModel getStudentById(@PathVariable int id) {
        return findStudentById(id);
    }

    @PostMapping("/create")
    public String createStudent(@RequestBody StudentModel student) {
        students.add(student);
        return "Student created: " + student.getName();
    }

    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody StudentModel updatedStudent) {
        StudentModel existingStudent = findStudentById(id);
        if (existingStudent != null) {
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setMarks(updatedStudent.getMarks());
            existingStudent.setSchool(updatedStudent.getSchool());
            return "Student updated: " + existingStudent.getName();
        } else {
            return "Student not found with id: " + id;
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        StudentModel student = findStudentById(id);
        if (student != null) {
            students.remove(student);
            return "Student deleted: " + student.getName();
        } else {
            return "Student not found with id: " + id;
        }
    }

    // Utility method to find a student by ID
    private StudentModel findStudentById(int id) {
        for (StudentModel student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}

