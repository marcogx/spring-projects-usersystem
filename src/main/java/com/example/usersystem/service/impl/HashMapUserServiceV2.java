package com.example.usersystem.service.impl;

import com.example.usersystem.domain.User;
import com.example.usersystem.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class HashMapUserServiceV2 implements UserService {


//    ORM  Object Relation Mapping  JPA

    private Map<Long, User> userRepository = new HashMap<>();

    @Override
    public User findById(Long id) {
        return userRepository.get(id);
    }

    @Override
    public User save(User input) {
        Long userId = input.getId();
        if (userId == null || !userRepository.containsKey(userId)) {
            userId = (long) (userRepository.size() + 1);
        }

        input.setId(userId);
        input.setStatus("created success");
        input.setRole("general");
        input.setCreated(new Date());
        input.setLastModified(new Date());

        userRepository.put(userId, input);
        return input;
    }
}
