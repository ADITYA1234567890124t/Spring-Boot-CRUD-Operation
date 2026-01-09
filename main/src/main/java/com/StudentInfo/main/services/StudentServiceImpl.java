package com.StudentInfo.main.services;

import com.StudentInfo.main.entities.Student;
import com.StudentInfo.main.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService
{
   @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student)
    {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentDetails(int id)
    {
        return studentRepository.findById(id);
    }

    @Override
    public Student updateStudentDetails(int id, Student newStudent)
    {
        Student studentData = studentRepository.findById(id).orElse(null);
        if(studentData != null)
        {
            return studentRepository.save(newStudent);
        }
        else
        {
            throw new RuntimeException("Student not found with id :"+id);
        }
    }

    @Override
    public void deleteStudent(int id)
    {
        studentRepository.deleteById(id);
    }
}
