package com.juli.SpringCourse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

@Service
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:custom-file.properties")
})
public class MyFirstService {

    private final MyFirstClass myFirstClass;

    @Value("${my.prop}")
    private String customProperty;

    @Value("${my.custom.property.int}")
    private Integer customPropertyInt;

    public MyFirstService(
            @Qualifier("bean1") MyFirstClass myFirstClass
    ) {
        this.myFirstClass = myFirstClass;
    }


    public String tellAStory(){
        return "The dependency is saying: " + myFirstClass.sayHello();
    }


    public String getCustomProperty() {
        return customProperty;
    }

    public Integer getCustomPropertyInt() {
        return customPropertyInt;
    }
}
