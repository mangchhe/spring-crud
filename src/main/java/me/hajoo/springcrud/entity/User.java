package me.hajoo.springcrud.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.hajoo.springcrud.dto.UserResponse;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
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

    public void changeName(String name) { this.name = name; }
    public void changeAge(Integer age) { this.age = age; }
    public void changeHeight(Integer height) { this.height = height; }
    public void changeWeight(Integer weight) { this.weight = weight; }
}