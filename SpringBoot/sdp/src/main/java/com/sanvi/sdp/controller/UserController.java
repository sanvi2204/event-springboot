package com.sanvi.sdp.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sanvi.sdp.model.Users;
import com.sanvi.sdp.service.UserService;

@RestController()
@RequestMapping("/api")

public class UserController {
    @Autowired
    private UserService uservice;

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody UserCreateRequest registerRequest) {
        User user = userService.createUser(registerRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/getusers")
    public List<Users> GetUsers() {
        return uservice.getUsers();
    }
   
    @GetMapping("/login")
    public boolean login(@RequestParam String email, @RequestParam String password) {
        Users existinguser = uservice.findUserByEmail(email);
        return existinguser!=null && existinguser.getPassword().equals(password);
    }

    @PostMapping("/register")
    public Users AddUsers(@RequestBody Users user) {
        return uservice.addUsers(user);
    }

    @DeleteMapping("/delete/{uid}")
    public String DeleteUser(@PathVariable Long uid) {
        return uservice.deleteUser(uid);
    }
    

}