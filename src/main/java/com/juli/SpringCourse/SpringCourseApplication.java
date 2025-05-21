package com.juli.SpringCourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCourseApplication {

	public static void main(String[] args) {

		var ctx = SpringApplication.run(SpringCourseApplication.class, args);

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellAStory());

	}



}
