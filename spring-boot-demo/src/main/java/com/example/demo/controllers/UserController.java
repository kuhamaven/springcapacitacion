package com.example.demo.controllers;

import com.example.demo.models.UserModel;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserModel getUserModel(@PathVariable Integer id) {
        return this.userService.findUserById(id);
    }

    @PostMapping()
    public ResponseEntity createUser(@Valid @RequestBody UserModel userModel) {
        return ResponseEntity.ok(this.userService.saveUser(userModel));
    }

    @PutMapping()
    public ResponseEntity updateUser(@Valid @RequestBody UserModel userModel) {
        return ResponseEntity.ok(this.userService.updateUser(userModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        return ResponseEntity.ok(this.userService.deleteUser(id));
    }
}
