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
    public Student createStudent(
            @RequestBody Student student
    ){
        return repository.save(student);

    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(
            @PathVariable("student-id") Integer id){

        repository.deleteById(id);

    }

}
