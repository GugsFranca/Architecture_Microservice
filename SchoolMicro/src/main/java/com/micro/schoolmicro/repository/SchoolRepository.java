package com.micro.schoolmicro.repository;

import com.micro.schoolmicro.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
