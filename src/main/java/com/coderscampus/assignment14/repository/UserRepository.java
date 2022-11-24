package com.coderscampus.assignment14.repository;


import com.coderscampus.assignment14.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.TreeSet;

@Repository
public class UserRepository {
    private Set<User> users = new TreeSet<>();

    public User saveUser(User user) {
        if (users.size() == 0) {
            user.setId(String.valueOf(1L));

        } else {
            User lastUser = ((TreeSet<User>) users).last();
            user.setId(lastUser.getId());

        }
        users.add(user);
        return user;

    }
}