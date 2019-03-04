package com.nsv.jsmbaba.controller;

import com.nsv.jsmbaba.domain.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final AtomicLong atomicLong = new AtomicLong();
    private static final String template = "Hello %s";

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name",defaultValue = "world") String name){
        return new Greeting(atomicLong.getAndIncrement(),String.format(template,name));
    }
}
