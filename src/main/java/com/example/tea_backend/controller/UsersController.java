package com.example.tea_backend.controller;

import com.example.tea_backend.domain.Users;
import com.example.tea_backend.repository.UsersRepository;
import com.example.tea_backend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@Controller
@RequestMapping(path="/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UsersService usersService;

    @GetMapping
    public @ResponseBody Iterable<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @PostMapping(path="/create")
    public @ResponseBody String createNewUser (@RequestBody Users request) {
        Users users = new Users();
        users.setName(request.getName());
        users.setPassword(request.getPassword());
        usersRepository.save(users);
        return "create";
    }

    @GetMapping("/find-by-id")
    public @ResponseBody Optional<Users> findByUserId(@RequestParam(name="userId") long userId) {
        return usersRepository.findByUserId(userId);
    }

    @PostMapping("/login")
    public @ResponseBody ResponseEntity<Optional<Users>> login(@RequestBody Users request) {
        return ResponseEntity.ok(usersService.login(request));
    }
}
