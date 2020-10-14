package me.right42.querydsl.repository;

import me.right42.querydsl.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
