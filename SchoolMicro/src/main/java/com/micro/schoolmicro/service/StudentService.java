package com.micro.schoolmicro.service;

import com.micro.schoolmicro.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service", url = "${application.config.students-url}")
public interface StudentService {
    @GetMapping("/school/{schoolId}")
    List<Student> findAllStudentsBySchool(@PathVariable Integer schoolId);
}
