package com.example.aispringboot.controller;

import com.example.aispringboot.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Test {
    @GetMapping("/test")
    public Object test() {
//        Result result = new Result();
//        result.setCode("200");

        return Result.success("Hello");
    }
}
