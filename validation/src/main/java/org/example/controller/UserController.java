package org.example.controller;

import org.example.domain.User;
import org.example.domain.UserV2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @PostMapping("/users")
    ResponseEntity<String> addUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok("User is valid");
    }

    @PostMapping("/v2/users")
    ResponseEntity<String> addUserV2(@Valid @RequestBody UserV2 user) {
        return ResponseEntity.ok("User V2 is valid");
    }
}
