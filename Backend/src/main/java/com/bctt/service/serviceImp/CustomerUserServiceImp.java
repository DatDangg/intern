package com.bctt.service.serviceImp;
import com.bctt.model.User;
import com.bctt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerUserServiceImp implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findByEmailDN(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email - " + email);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(user.getEmailDN(), user.getPassword(), authorities);
    }

    // 🔥 Thêm phương thức này để lấy thông tin User theo email
    public User getUserByEmail(String email) {
        return userRepository.findByEmailDN(email);
    }


/*
    private final UserRepository userRepository;

    @Autowired
    public CustomerUserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findByEmailDN(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email - " + email);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(user.getEmailDN(), user.getPassword(), authorities);
    }

 */
}
