package me.hajoo.springcrud.service;

import me.hajoo.springcrud.dto.CreateUserRequest;
import me.hajoo.springcrud.entity.User;

public interface UserService {

    User createUser(CreateUserRequest createUserRequest);
}
