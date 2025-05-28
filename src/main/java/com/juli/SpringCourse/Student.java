package com.juli.SpringCourse;

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
}
