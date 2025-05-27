package com.juli.SpringCourse;

import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello from my first controller";
    }

    @PostMapping("/post")
    public String post(@RequestBody String message){
        return "Request accepted and the message is: " + message;
    }

}
