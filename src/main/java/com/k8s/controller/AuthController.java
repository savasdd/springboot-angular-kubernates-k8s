package com.k8s.controller;

import com.k8s.model.User;
import com.k8s.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class AuthController {

    @Autowired
    private UserService service;

    @Operation(summary = "validate username")
    @PostMapping(value = "/auth")
    public ResponseEntity<User> getUser(@RequestBody User user) throws Exception {
        return new ResponseEntity<>(service.getUser().getUser(user), HttpStatus.ACCEPTED );
    }
}
