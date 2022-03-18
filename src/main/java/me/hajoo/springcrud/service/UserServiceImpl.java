package me.hajoo.springcrud.service;

import lombok.RequiredArgsConstructor;
import me.hajoo.springcrud.dto.CreateUserRequest;
import me.hajoo.springcrud.dto.UserResponse;
import me.hajoo.springcrud.entity.User;
import me.hajoo.springcrud.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public User createUser(final CreateUserRequest createUserRequest) {
        return userRepository.save(new User(
                createUserRequest.getName(),
                createUserRequest.getAge(),
                createUserRequest.getHeight(),
                createUserRequest.getWeight()
        ));
    }

    @Override
    public List<UserResponse> findUsers() {
        return userRepository.findAll().stream()
                .map(User::entityToUserResponse)
                .collect(Collectors.toList());
    }
}
