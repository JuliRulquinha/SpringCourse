package com.juli.SpringCourse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfig {

    @Bean
    public InjectionType secondBean(){
        return new InjectionType("Using plain @Bean. Injection using the deafult bean name given by Spring.");
    }

    @Bean(name = "bean1")
    public InjectionType firstBean(){
        return new InjectionType("Using @Bean(\"beanName\"). Injection using a bean with explicit naming, the name attribute also accepts an array of names.");
    }

    @Bean
    @Primary
    public InjectionType thirdBean(){
        return new InjectionType("Injection using the @Primary annotation, this bean will be used preferentially when there are multiple beans of the same type.");
    }

}
