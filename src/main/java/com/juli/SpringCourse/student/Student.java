package com.juli.SpringCourse.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.juli.SpringCourse.school.School;
import com.juli.SpringCourse.studentProfile.StudentProfile;
import jakarta.persistence.*;

@Entity
@Table(name = "T STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String lastName;
    private String email;
    private int age;

    @ManyToOne
    @JoinColumn(
            name = "school-id"
    )
    @JsonBackReference
    private School school;



    @OneToOne(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    private StudentProfile studentProfile;

    public Student() {
    }

    public Student(String name, Integer id, String lastName, String email, int age) {
        this.name = name;
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }



    public Integer getId() {
            return id;
        }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
            this.email = email;
        }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }
}
