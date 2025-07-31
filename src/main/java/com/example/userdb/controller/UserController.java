package com.example.userdb.controller;

import com.example.userdb.dto.*;
import com.example.userdb.model.User;
import com.example.userdb.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // Add user (password stored plaintext)
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody AuthRequest req) {
        try {
            User user = new User(req.getUsername(), req.getPassword(), null);
            User saved = service.addUser(user);
            // hide password in response
            saved.setPassword(null);
            return ResponseEntity.ok(saved);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new MessageResponse(e.getMessage()));
        }
    }

    // Get json_url if credentials valid
    @PostMapping("/get-json-url")
    public ResponseEntity<?> getJsonUrl(@RequestBody AuthRequest req) {
        try {
            String jsonUrl = service.getJsonUrl(req.getUsername(), req.getPassword());
            return ResponseEntity.ok(new JsonUrlResponse(jsonUrl));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new MessageResponse("Invalid credentials"));
        }
    }

    // Update json_url if credentials valid
    @PostMapping("/update-json-url")
    public ResponseEntity<?> updateJsonUrl(@RequestBody UpdateJsonUrlRequest req) {
        try {
            User updated = service.updateJsonUrl(req.getUsername(), req.getPassword(), req.getJsonUrl());
            return ResponseEntity.ok(new JsonUrlResponse(updated.getJsonUrl()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new MessageResponse("Invalid credentials"));
        }
    }
}
