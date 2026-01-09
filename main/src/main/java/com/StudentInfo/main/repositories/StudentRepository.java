package com.StudentInfo.main.repositories;

import com.StudentInfo.main.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer>
{

}
