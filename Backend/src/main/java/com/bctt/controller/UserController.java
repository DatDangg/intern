package com.bctt.controller;

import com.bctt.dto.reponse.UserResponse;
import com.bctt.dto.request.UserProfileRequest;
import com.bctt.dto.request.UserRequest;
import com.bctt.model.User;
import com.bctt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    UserResponse createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @GetMapping("/getId/{userId}")
    UserResponse getUserById(@PathVariable("userId") Long userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/update/{userId}")
    UserResponse updateUser(@RequestBody UserProfileRequest userProfileRequest, @PathVariable Long userId) {
        return userService.updateUser(userId,userProfileRequest);
    }

    @DeleteMapping("/delete/{userId}")
    String deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return "User has been deleted";
    }
}
