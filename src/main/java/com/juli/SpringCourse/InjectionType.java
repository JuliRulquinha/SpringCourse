package com.juli.SpringCourse;

public class InjectionType {
    
    private String type;

    public InjectionType(String injectionType) {
        this.type = injectionType;
    }

    public String getInjectionType() {
        return "The injection type is: " + type;
    }
}
