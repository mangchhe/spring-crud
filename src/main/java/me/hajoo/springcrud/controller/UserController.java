package me.hajoo.springcrud.controller;

import lombok.RequiredArgsConstructor;
import me.hajoo.springcrud.dto.CreateUserRequest;
import me.hajoo.springcrud.dto.UserResponse;
import me.hajoo.springcrud.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest createUserRequest) {
        userService.createUser(createUserRequest);
        return ResponseEntity.ok("");
    }

    @GetMapping("")
    public ResponseEntity<List<UserResponse>> findUsers() {
        final List<UserResponse> body = userService.findUsers();
        return ResponseEntity.ok(body);
    }
}
