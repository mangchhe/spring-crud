package me.hajoo.springcrud.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserResponse {

    private final Long id;
    private final String name;
    private final Integer age;
    private final Integer height;
    private final Integer weight;
}