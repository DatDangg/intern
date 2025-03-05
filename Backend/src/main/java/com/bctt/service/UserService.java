package com.bctt.service;

import com.bctt.dto.reponse.UserResponse;
import com.bctt.dto.request.UserProfileRequest;
import com.bctt.dto.request.UserRequest;
import com.bctt.model.User;

import java.util.List;

public interface UserService {
    public UserResponse createUser(UserRequest userRequest);
    public UserResponse getUser(Long id);
    public UserResponse updateUser(Long id, UserProfileRequest userProfileRequest);
    public void deleteUser(Long id);
}
