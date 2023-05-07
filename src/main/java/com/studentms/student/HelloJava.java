package com.studentms.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloJava {
    
    // @RequestMapping(  value = "/hello", method = RequestMethod.GET )
    @GetMapping("/hello")
    public String hello() {
        return "Hello World. test eeeee";
    }

}
