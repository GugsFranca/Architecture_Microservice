package com.micro.schoolmicro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private UUID id;
    private String firstname;
    private String lastname;
    private String email;
    private Integer schoolId;
}
