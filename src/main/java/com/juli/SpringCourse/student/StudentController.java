package com.juli.SpringCourse.student;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<StudentResponseDto> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDto getStudentById(
            @PathVariable("student-id") Integer id)
    {
        return studentService.getStudentById(id);

    }

    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDto> getStudentByName(
            @PathVariable("student-name") String name){

        return studentService.getStudentByName(name);
    }

    @PostMapping("/students")
    public StudentResponseDto saveStudent(
            @Valid @RequestBody StudentDto dto
    ){
        return studentService.saveStudent(dto);
    }



    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(
            @PathVariable("student-id") Integer id){

        studentService.deleteStudentById(id);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex
    ){
        var errors = new HashMap<String, String>();
        ex.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

    }

}
