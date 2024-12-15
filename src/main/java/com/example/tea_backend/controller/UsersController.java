package com.example.tea_backend.controller;

import com.example.tea_backend.domain.User;
import com.example.tea_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    //test
    @GetMapping(path="/all")
    public @ResponseBody List<User>

    @PostMapping(path="/create")
    public @ResponseBody String createNewUser (@RequestParam String name, @RequestParam String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        userRepository.save(user);
        return "create";
    }

    @GetMapping("/")
    public @ResponseBody Optional<User> findByUserId(@RequestParam long userId) {
        return userRepository.findByUserId(userId);
    }
}
