package com.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")        //RequestMapping uri 를 지정해주는 Annotaion 주소맵핑...
public class ApiController {   //해당 class 는 RestAPI 처리하는 Controller

    @GetMapping("/hello")  //http://localhost:9090/hello
    public String hello(){
        return "hello spring boot!";
    }
}
