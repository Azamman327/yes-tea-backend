package com.example.tea_backend.service;

import com.example.tea_backend.domain.Users;
import com.example.tea_backend.repository.UsersRepository;

import javax.swing.text.html.Option;
import java.util.NoSuchElementException;
import java.util.Optional;

public class UsersService {
    private UsersRepository usersRepository;

    final int NO_USER = 0;
    final int SUCCESS = 1;
    final int FAILURE = 2;


    public int login(String name, String enteredPassword) {
        Optional<Users> user = usersRepository.findByName(name);
        String storedPassword = Optional.ofNullable(user.get().getPassword()).orElse(null);


        if (storedPassword == null) {
            return NO_USER;
        }

        if (enteredPassword.equals(storedPassword)) {
            return SUCCESS;
        }
        else {
            return FAILURE;
        }
    }
}
