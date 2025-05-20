package com.edigest.journalApp.controller;

import com.edigest.journalApp.entity.Users;
import com.edigest.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    public UserService userService;

    @GetMapping("/all")
    public List<Users> getAllUsers(){
        return userService.getAll();
    }

    @GetMapping("/health-check")
    public String healthCheck(){
        return "ok";
    }

    @PostMapping("/create-user")
    public void createUsers(@RequestBody Users user){
        userService.saveEntry(user);
    }

}
