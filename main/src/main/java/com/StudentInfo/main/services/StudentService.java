package com.StudentInfo.main.services;

import com.StudentInfo.main.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService
{
    public Student createStudent(Student student);
    public List<Student> getAllStudents();
    public Optional<Student> getStudentDetails(int id);
    public Student updateStudentDetails(int id, Student student);
    public void deleteStudent(int id);
}
