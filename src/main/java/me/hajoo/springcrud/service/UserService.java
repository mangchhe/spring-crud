package me.hajoo.springcrud.service;

import me.hajoo.springcrud.dto.CreateUserRequest;
import me.hajoo.springcrud.dto.UpdateUserRequest;
import me.hajoo.springcrud.dto.UserResponse;
import me.hajoo.springcrud.entity.User;

import java.util.List;

public interface UserService {

    User createUser(CreateUserRequest createUserRequest);
    List<UserResponse> findUsers();
    User updateUser(UpdateUserRequest updateUserRequest);
}
