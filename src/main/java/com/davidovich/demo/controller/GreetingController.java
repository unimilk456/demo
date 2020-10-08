package com.davidovich.demo.controller;

import com.davidovich.demo.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class GreetingController {

    @Value("${greeting.prefix}")
    private String prefix;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return prefix + name;
    }
    @GetMapping("/test")
    public ResponseEntity<Person> response(@RequestParam String name) {
        Person p = new Person(1,"Sergii", "Kiev");
        p.setName(name);
        return ResponseEntity.ok(p);
    }


}
