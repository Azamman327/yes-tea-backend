package com.example.tea_backend.service;

import com.example.tea_backend.domain.Users;
import com.example.tea_backend.exception.ErrorCode;
import com.example.tea_backend.exception.InvalidUserException;
import com.example.tea_backend.exception.WrongPasswordException;
import com.example.tea_backend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.text.html.Option;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public Optional<Users> checkLogin(Users requestUser, Optional<Users> user) {

        if (user.get().getPassword().equals(requestUser.getPassword())) {
            return user;
        } else {
            throw new WrongPasswordException("wrong password", ErrorCode.WRONG_PASSWORD);
        }
    }

    public Optional<Users> login(Users requestUser) {
        Optional<Users> user = usersRepository.findByName(requestUser.getName());

        if (user.isEmpty()) {
            throw new InvalidUserException("invalid user", ErrorCode.INVALID_USER);
        }
        else {
            return checkLogin(requestUser, user);
        }
    }
}
