package com.school.studentmicro.repository;

import com.school.studentmicro.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    List<Student> findAllBySchoolId(Integer schoolID);
    boolean existsByEmail(String email);
}
