package com.StudentInfo.main.controllers;

import com.StudentInfo.main.entities.Student;
import com.StudentInfo.main.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController
{
    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public Student addStudentDetails(@RequestBody Student student)
    {
        return studentService.createStudent(student);
    }

    @GetMapping("/student")
    public List<Student> getAllStudentDetails()
    {
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentDetails(@PathVariable int id)
    {
        Student student = studentService.getStudentDetails(id).orElse(null);
        if(student != null)
        {
            return ResponseEntity.ok().body(student);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudentDetails(@PathVariable int id, @RequestBody Student student)
    {
        Student updatedStudent = studentService.updateStudentDetails(id,student);
        if(updatedStudent != null)
        {
            return ResponseEntity.ok(updatedStudent);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id)
    {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }




}
