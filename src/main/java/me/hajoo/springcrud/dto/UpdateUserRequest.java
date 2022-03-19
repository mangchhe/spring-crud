package me.hajoo.springcrud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {

    Long id;
    String name;
    Integer age;
    Integer height;
    Integer weight;
}
