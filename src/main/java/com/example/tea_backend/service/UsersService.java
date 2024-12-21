package com.example.tea_backend.service;

import com.example.tea_backend.domain.Users;
import com.example.tea_backend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    final String NO_USER = "NO_USER";
    final String SUCCESS = "SUCCESS";
    final String FAILURE = "FAILURE";


    public String login(String name, String enteredPassword) {
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
