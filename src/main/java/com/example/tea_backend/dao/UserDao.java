package com.example.tea_backend.dao;

import com.example.tea_backend.domain.User;
import com.example.tea_backend.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserDao implements UserRepository {

    private static Map<Long, User> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public long createUser(User user) {
        user.setUserId(++sequence);
        long userId = user.getUserId();
        store.put(userId, user);
        return userId;
    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByName(String name) {
        return Optional.empty();
    }
}
