package com.inventory.smart_inventory.controller;

import com.inventory.smart_inventory.entity.User;
import com.inventory.smart_inventory.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthCollection {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        User saveUser = userService.registerUser(user);
        return ResponseEntity.ok(saveUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {

        String token = userService.loginUser(user);
        System.out.println("token......." + token);
        return ResponseEntity.ok(token);
    }

}
