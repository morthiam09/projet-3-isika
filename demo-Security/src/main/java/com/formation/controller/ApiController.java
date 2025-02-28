package com.formation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @RequestMapping("/public")
    public String publicApi(){
        return "{\"message\":\"PUBLIC API\"}";
    }

    @RequestMapping("/user")
    public String userApi(){
        return "{\"message\":\"USER API\"}";
    }

    @RequestMapping("/admin")
    public String adminApi(){
        return "{\"message\":\"ADMIN API\"}";
    }
}
