package com.study.first_spring_app.controllers;

import com.study.first_spring_app.domains.User;
import com.study.first_spring_app.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping
    public String helloWorld() {
        return helloWorldService.helloWorld("Deyweson");
    }

    @PostMapping("/{id}")
    public String helloWorldPost(
            @PathVariable String id,
            @RequestParam(value = "filter", defaultValue = "nenhum") String filter,
            @RequestBody User body) {
        return "Hello World Post " + body.getName() + id;
    }
}
