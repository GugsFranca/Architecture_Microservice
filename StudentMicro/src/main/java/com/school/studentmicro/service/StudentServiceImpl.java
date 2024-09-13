package com.school.studentmicro.service;

import com.school.studentmicro.model.Student;
import com.school.studentmicro.repository.StudentRepository;
import com.school.studentmicro.service.inter.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;

    @Override
    public Student saveStudent(Student student){
        if (!repository.existsByEmail(student.getEmail())) {
            return repository.save(student);
        }else throw new IllegalArgumentException("This email is already registered");

    }
    @Override

    public List<Student> findAllStudents(){
        try {
            return repository.findAll();
        }catch (Exception e){
            throw new NoSuchElementException();
        }    }
    @Override

    public List<Student> findAllStudentsBySchool(Integer schoolID){
        try {
            return repository.findAllBySchoolId(schoolID);
        }catch (Exception e){
            throw new NoSuchElementException("this school id does not exist");
        }
    }

}
