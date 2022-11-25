package com.coderscampus.assignment14.repository;


import com.coderscampus.assignment14.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.TreeSet;

@Repository
public class UserRepository {
    private final Set<User> users = new TreeSet<>();

    public User saveUser(User user) {
        if (users.isEmpty()) {
            user.setId(1L);

        } else {
            User lastUser = ((TreeSet<User>) users).last();
            user.setId(lastUser.getId());

        }
        users.add(user);
        return user;

    }
}