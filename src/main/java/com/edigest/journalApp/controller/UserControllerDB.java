package com.edigest.journalApp.controller;

import com.edigest.journalApp.entity.JournalEntry;
import com.edigest.journalApp.entity.Users;
import com.edigest.journalApp.service.JournalEntryService;
import com.edigest.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserControllerDB {

    @Autowired
    public UserService userService;

    @GetMapping("/all")
    public List<Users> getAllUsers(){
        return userService.getAll();
    }
    @PostMapping()
    public void createUsers(@RequestBody Users user){
        userService.saveEntry(user);
    }
    @PutMapping("/{userName}")
    public ResponseEntity<?> updateUser(@RequestBody Users user, @PathVariable String userName){
        Users userinDB= userService.findByUserName(userName);
        if(userinDB!=null){
            userinDB.setUserName(user.getUserName());
            userinDB.setPassword(user.getPassword());
            userService.saveEntry(userinDB);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
}
