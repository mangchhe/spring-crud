package me.hajoo.springcrud.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.hajoo.springcrud.dto.UserResponse;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    Integer age;
    Integer height;
    Integer weight;

    public User(final String name, final Integer age, final Integer height, final Integer weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public UserResponse entityToUserResponse() {
        return new UserResponse(id, name, age, height, weight);
    }
}