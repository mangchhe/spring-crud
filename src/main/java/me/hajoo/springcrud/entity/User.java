package me.hajoo.springcrud.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    Integer age;
    Integer height;
    Integer weight;
}