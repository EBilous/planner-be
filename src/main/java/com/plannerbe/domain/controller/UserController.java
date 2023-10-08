package com.plannerbe.domain.controller;

import com.plannerbe.domain.dto.UserDTO;
import com.plannerbe.domain.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping("/admin/info")
    public String getAdminInfo() {
        return "Hello admin";
    }

    @PreAuthorize(value = "hasRole('USER')")
    @GetMapping("/user/info")
    public String getUser() {
        return "Hello user";
    }

    @GetMapping("/public")
    public String publicInfo() {
        return "Welcome to our API";
    }

    @PreAuthorize(value = "hasRole('USER')")
    @GetMapping("/user/profile/{userId}")
    public ResponseEntity<Optional<UserDTO>> getParameter(@PathVariable("userId") String userId){
        return ResponseEntity.ok(service.getUserById(Long.valueOf(userId)));
    }


    @PreAuthorize(value = "hasRole('USER')")
    @GetMapping("/user/profile")
    public ResponseEntity<Optional<UserDTO>> getByEmail(@RequestParam("email") String email){
        return ResponseEntity.ok(service.findByEmail(email));
    }

    @PreAuthorize(value = "hasRole('USER')")
    @PostMapping("/user/sign-up")
    public ResponseEntity<UserDTO> userSignup(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(service.createUser(userDTO));
    }
}
