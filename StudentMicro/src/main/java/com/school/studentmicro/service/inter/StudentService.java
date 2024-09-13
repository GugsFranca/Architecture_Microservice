package com.school.studentmicro.service.inter;

import com.school.studentmicro.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> findAllStudents();
    public List<Student> findAllStudentsBySchool(Integer schoolID);
}
