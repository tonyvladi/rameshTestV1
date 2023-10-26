package net.javaguides.springbootrestapi.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    //http GET request
    // http://localhost:8080/hello-world

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }
}
