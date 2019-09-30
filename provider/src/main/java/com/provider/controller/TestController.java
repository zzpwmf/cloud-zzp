package com.provider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello")
    public String testRest(){
        return "hello, welcome to here!";
    }

}
