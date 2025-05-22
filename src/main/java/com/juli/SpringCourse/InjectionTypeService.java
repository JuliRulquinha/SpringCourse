package com.juli.SpringCourse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

@PropertySources({
    @PropertySource("classpath:custom.properties"),
    @PropertySource("classpath:custom-file.properties"),
})

@Service
public class InjectionTypeService {
    
    private final InjectionType injectionType;

    @Value("${my.prop}")
    private String customProperty;

    @Value("${my.custom.property}")
    private String myCustomProperty;

    @Value("${my.prop.2}")
    private String customProperty2;

    @Value("${my.custom.property.int}")
    private Integer customPropertyInt;


    @Value("${default.properties.file}")
    private String defaultFileProperty;

    public InjectionTypeService(
        @Qualifier("secondBean") InjectionType injectionType
        ) {
        this.injectionType = injectionType;
    }
    

    public String printInjectionInfo(){
        return "Injection info - " + injectionType.getInjectionType();
    }

    public String getCustomProperty() {
        return customProperty;
    }

    public String getCustomProperty2() {
        return customProperty2;
    }

    public Integer getCustomPropertyInt() {
        return customPropertyInt;
    }

    public String getDefaultFileProperty() {
        return defaultFileProperty;
    }

    public String getMyCustomProperty() {
        return myCustomProperty;
    }

    
}
