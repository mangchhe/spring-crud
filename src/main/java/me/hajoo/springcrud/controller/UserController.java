package me.hajoo.springcrud.controller;

import lombok.RequiredArgsConstructor;
import me.hajoo.springcrud.dto.CreateUserRequest;
import me.hajoo.springcrud.dto.UpdateUserRequest;
import me.hajoo.springcrud.dto.UserResponse;
import me.hajoo.springcrud.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<String> createUser(@RequestBody @Valid final CreateUserRequest createUserRequest) {
        userService.createUser(createUserRequest);
        return ResponseEntity.ok("");
    }

    @GetMapping("")
    public ResponseEntity<List<UserResponse>> findUsers() {
        final List<UserResponse> body = userService.findUsers();
        return ResponseEntity.ok(body);
    }

    @PostMapping("/profile")
    public ResponseEntity<String> updateUser(@RequestBody @Valid final UpdateUserRequest updateUserRequest) {
        userService.updateUser(updateUserRequest);
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable final Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("");
    }
}
