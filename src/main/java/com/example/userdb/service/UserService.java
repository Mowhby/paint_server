package com.example.userdb.service;

import com.example.userdb.model.User;
import com.example.userdb.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User addUser(User user) {
        if (repo.existsById(user.getUsername())) {
            throw new IllegalArgumentException("User already exists");
        }
        return repo.save(user);
    }

    private Optional<User> findByUsername(String username) {
        return repo.findById(username);
    }

    public String getJsonUrl(String username, String password) {
        User user = findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password"));
        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid username or password");
        }
        return user.getJsonUrl();
    }

    public User updateJsonUrl(String username, String password, String newJsonUrl) {
        User user = findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password"));
        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid username or password");
        }
        user.setJsonUrl(newJsonUrl);
        return repo.save(user);
    }
}
