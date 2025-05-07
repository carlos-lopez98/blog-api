package com.blogplatform.blogapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
@RequestMapping("/health")
public class TestingController {

    @GetMapping
    public ResponseEntity<String> testingConnections(){
        return ResponseEntity.ok("Blog API is up!");
    }
}
