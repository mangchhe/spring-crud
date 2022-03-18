package me.hajoo.springcrud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    String name;
    Integer age;
    Integer height;
    Integer weight;
}