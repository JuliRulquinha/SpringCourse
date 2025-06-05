package com.juli.SpringCourse.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent(){
        StudentDto dto = new StudentDto(
                "John",
                "Doe",
                "juli@student.com",
                1
        );
        Student student = mapper.toStudent(dto);

        assertEquals(dto.name(), student.getName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());
    }

    @Test
    public void should_throw_null_pointer_exception_when_studentDto_is_null(){
       var msg = assertThrows(NullPointerException.class, () -> mapper.toStudent(null));
        assertEquals("The student Dto should not be null", msg.getMessage());
    }

    @Test
    public void shouldMapStudentToStudentResponseDto(){
        Student student= new Student(
                "Jane",
                "Smith",
                "jane@mail.com",
                24
        );
        StudentResponseDto dto = mapper.toStudentResponseDto(student);

        assertEquals(dto.name(), student.getName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
    }

}