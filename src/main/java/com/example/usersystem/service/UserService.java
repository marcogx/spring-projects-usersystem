package com.example.usersystem.service;

import com.example.usersystem.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findById(Long id);
    User save(User input);
}
