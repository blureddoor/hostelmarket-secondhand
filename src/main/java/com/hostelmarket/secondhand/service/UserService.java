package com.hostelmarket.secondhand.service;

import com.hostelmarket.secondhand.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final Map<Long, User> users = new HashMap<>();
    private long nextId = 1;

    public UserService() {
        save(new User(null, "Leo", "leo@email.com"));
    }

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public User findById(Long id) {
        return users.get(id);
    }

    public User save(User user) {
        if (user.getId() == null) user.setId(nextId++);
        users.put(user.getId(), user);
        return user;
    }
    public User getLoggedUser() {
    // Siempre devuelve el primer usuario creado ("Leo").
    return users.values().stream().findFirst().orElse(null);
    }
}
