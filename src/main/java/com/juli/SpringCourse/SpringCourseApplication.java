package com.juli.SpringCourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCourseApplication {

	public static void main(String[] args) {

		var ctx = SpringApplication.run(SpringCourseApplication.class, args);

		InjectionTypeService injectionTypeService = ctx.getBean(InjectionTypeService.class);
		System.out.println("\n" + injectionTypeService.printInjectionInfo());
		System.out.println("\nUsing @Value to inject properties from application.properties and other files spcified in the @PropertySource annotation");
		System.out.println("\n" + injectionTypeService.getCustomProperty());
		System.out.println("\n" + injectionTypeService.getCustomProperty2());
		System.out.println("\nAn integer coming from from the application.properties: " + injectionTypeService.getCustomPropertyInt());
		System.out.println("\n" + injectionTypeService.getDefaultFileProperty());
	}



}
