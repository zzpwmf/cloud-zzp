package com.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提供方
 * @author
 */
@RestController
//@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello")
    public String testRest(){
        return "hello, welcome to here!";
    }

}
