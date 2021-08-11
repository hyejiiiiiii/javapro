package com.example.hello.controller;

import dto.UserRequest;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello")
    public String getHello(){
        return "get hello";
    }

    @RequestMapping(path = "hi", method = RequestMethod.GET)
    public String hi(){
        return "hi";
    }

    @RequestMapping(path = "plustest", method = RequestMethod.GET)
    public double plusTest(){
        double num = 1;
        double num2 = 2 ;
        double result = num + num2;
        return result;
    }

    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName){
        System.out.println("PathVariable:" + pathName);
        return pathName;
    }

    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){
        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach( entry->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());

            sb.append(entry.getKey()+"= " + entry.getValue()+"\n");
        });
        return sb.toString();
    }

    @RequestMapping(path="query-param02", method = RequestMethod.GET)
    public String queryParam02(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam int age
    ){
        StringBuilder sb = new StringBuilder();
        sb.append(name+email+age);
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        System.out.println(sb.toString());

        return name+ " "+ email +" "+ age;

    }

    @RequestMapping(path = "query-param03", method = RequestMethod.GET)
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();


    }


}
