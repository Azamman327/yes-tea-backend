package com.example.tea_backend.repository;

import com.example.tea_backend.domain.User;

import java.util.Optional;

public interface UserRepository {
    long createUser(User user);
    //Optional : 찾는 객체가 없을 시 NULL 반환
    Optional<User> findById(int id);
    Optional<User> findByName(String name);
}
