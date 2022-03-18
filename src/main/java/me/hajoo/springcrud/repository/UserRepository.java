package me.hajoo.springcrud.repository;

import me.hajoo.springcrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
