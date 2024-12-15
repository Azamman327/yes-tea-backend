package com.example.tea_backend.repository;

import com.example.tea_backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //Optional : 찾는 객체가 없을 시 NULL 반환
    Optional<User> findByUserId(long userId);
    Optional<User> findByName(String name);
}
