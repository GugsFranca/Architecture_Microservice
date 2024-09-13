package com.micro.schoolmicro.controller;

import com.micro.schoolmicro.DTO.SchoolDto;
import com.micro.schoolmicro.model.School;
import com.micro.schoolmicro.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService service;
    private final Environment environment;


    @PostMapping
    public ResponseEntity<School> saveSchool(@RequestBody School school) {

        service.saveSchool(school);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(school.getId())
                .toUri();

        return ResponseEntity.created(uri).body(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAllSchool() {

        return ResponseEntity.ok(service.findAllSchools());
    }

    @GetMapping("/with-students/{schoolId}")
    public ResponseEntity<SchoolDto> findAllStudentsBySchoolId(@PathVariable("schoolId") Integer schoolId) {
        String port = environment.getProperty("local.server.port", "Port not found");
        System.out.println(port);
        return ResponseEntity.ok(service.findSchoolWithStudents(schoolId));
    }
}
