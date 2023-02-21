package com.example.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class web {
        @RequestMapping("/web")
        public String hello()
        { return "HelloWorld";}
}
