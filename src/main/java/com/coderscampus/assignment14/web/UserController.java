package com.coderscampus.assignment14.web;


import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    @ResponseBody
    public User createUser(@RequestBody String name) {
        return userService.createUser(name);
    }
}
