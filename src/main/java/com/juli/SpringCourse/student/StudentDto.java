package com.juli.SpringCourse.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto (
        @NotEmpty(message = "Name should not be empty")
         String name,
        @NotEmpty(message = "Last name should not be empty")
         String lastName,
         String email,
         Integer schoolId

){
}
