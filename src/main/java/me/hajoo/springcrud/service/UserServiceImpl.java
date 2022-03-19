package me.hajoo.springcrud.service;

import lombok.RequiredArgsConstructor;
import me.hajoo.springcrud.dto.CreateUserRequest;
import me.hajoo.springcrud.dto.UpdateUserRequest;
import me.hajoo.springcrud.dto.UserResponse;
import me.hajoo.springcrud.entity.User;
import me.hajoo.springcrud.exception.NotValidUserIdException;
import me.hajoo.springcrud.repository.UserRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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

    @Override
    @Transactional
    public User updateUser(final UpdateUserRequest updateUserRequest) {
        final User user = userRepository.findById(updateUserRequest.getId()).orElseThrow(NotValidUserIdException::new);
        if (StringUtils.hasText(updateUserRequest.getName())) {
            user.changeName(updateUserRequest.getName());
        }
        if (updateUserRequest.getAge() != null) {
            user.changeAge(updateUserRequest.getAge());
        }
        if (updateUserRequest.getWeight() != null) {
            user.changeWeight(updateUserRequest.getWeight());
        }
        if (updateUserRequest.getHeight() != null) {
            user.changeHeight(updateUserRequest.getHeight());
        }
        return user;
    }

    @Override
    @Transactional
    public Long deleteUser(final Long userId) {
        try {
            userRepository.deleteById(userId);
            return userId;
        } catch (EmptyResultDataAccessException e) {
            throw new NotValidUserIdException("잘못된 유저 id 입니다.");
        }
    }
}
