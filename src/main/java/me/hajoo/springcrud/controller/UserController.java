package me.hajoo.springcrud.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

    @Operation(summary = "회원가입", description = "회원가입")
    @PostMapping("")
    public ResponseEntity<String> createUser(@RequestBody @Valid final CreateUserRequest createUserRequest) {
        userService.createUser(createUserRequest);
        return ResponseEntity.ok("");
    }

    @Operation(summary = "모든 유저 조회", description = "모든 유저 조회")
    @GetMapping("")
    public ResponseEntity<List<UserResponse>> findUsers() {
        final List<UserResponse> body = userService.findUsers();
        return ResponseEntity.ok(body);
    }

    @Operation(summary = "프로필 수정", description = "프로필 수정")
    @PostMapping("/profile")
    public ResponseEntity<String> updateUser(@RequestBody @Valid final UpdateUserRequest updateUserRequest) {
        userService.updateUser(updateUserRequest);
        return ResponseEntity.ok("");
    }

    @Operation(summary = "회원탈퇴", description = "회원탈퇴")
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable final Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("");
    }
}
