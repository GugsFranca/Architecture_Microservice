package com.micro.schoolmicro.DTO;

import com.micro.schoolmicro.model.Student;
import lombok.Builder;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.micro.schoolmicro.model.School}
 */
@Builder
public record SchoolDto(String name, String email, List<Student> students) implements Serializable {
}