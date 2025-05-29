package com.juli.SpringCourse;

import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FirstController {

    private final StudentRepository repository;

    public FirstController(StudentRepository repository) {
        this.repository = repository ;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return repository.findAll();

    }

    @GetMapping("/students/{student-id}")
    public Student getStudentById(
            @PathVariable("student-id") Integer id){
        return repository.findById(id)
                .orElse(new Student());

    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> getStudentByName(
            @PathVariable("student-name") String name){
        return repository.findAllByNameContaining(name);

    }

    @PostMapping("/students")
    public StudentResponseDto createStudent(
            @RequestBody StudentDto dto
    ){

        var student = toStudent(dto);
        var savedstudent = repository.save(student);
        return toStudentResponseDto(savedstudent);
    }

    private StudentResponseDto toStudentResponseDto(Student student){
        return new StudentResponseDto(
                student.getName(),
                student.getLastName(),
                student.getEmail()
        );
    }

    private Student toStudent(StudentDto dto){
        var student = new Student();
        student.setName(dto.name());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);

        return student;
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(
            @PathVariable("student-id") Integer id){

        repository.deleteById(id);

    }

}
