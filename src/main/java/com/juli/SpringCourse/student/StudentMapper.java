package com.juli.SpringCourse.student;

import com.juli.SpringCourse.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public StudentResponseDto toStudentResponseDto(Student student){
        return new StudentResponseDto(
                student.getName(),
                student.getLastName(),
                student.getEmail()
        );
    }

    public Student toStudent(StudentDto dto){
        if(dto == null){
            throw new NullPointerException("The student Dto should not be null");
        }
        var student = new Student();
        student.setName(dto.name());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);

        return student;
    }
}
