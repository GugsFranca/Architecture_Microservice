package com.micro.schoolmicro.service;

import com.micro.schoolmicro.DTO.SchoolDto;
import com.micro.schoolmicro.model.School;
import com.micro.schoolmicro.repository.SchoolRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository repository;
    private final StudentService client;

    public void saveSchool(School school){
        repository.save(school);
    }
    public List<School> findAllSchools(){
        return repository.findAll();
    }

    public SchoolDto findSchoolWithStudents(Integer schoolId){
        var school = repository.findById(schoolId).orElse(
                School.builder().name("NOT_FOUND").email("NOT_FOUND").build()
        );
        var students = client.findAllStudentsBySchool(schoolId);
        return SchoolDto.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
