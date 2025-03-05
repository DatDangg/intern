package com.bctt.controller;

import com.bctt.config.JwtProvider;
import com.bctt.dto.reponse.AuthResponse;
import com.bctt.dto.request.ApiReponse;
import com.bctt.dto.request.AuthRequest;
import com.bctt.model.User;
import com.bctt.service.serviceImp.CustomerUserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {
    private final CustomerUserServiceImp customerUserServiceImp;
    private final JwtProvider jwtProvider;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public AuthController(CustomerUserServiceImp customerUserServiceImp, JwtProvider jwtProvider) {
        this.customerUserServiceImp = customerUserServiceImp;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping()
    public ResponseEntity<AuthResponse> loginUserHandler(@RequestBody AuthRequest authRequest) {
        String email = authRequest.getEmail();
        String password = authRequest.getPassword();

        Authentication authentication = authenticate(email, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 🔥 Lấy user từ database theo email
        User user = customerUserServiceImp.getUserByEmail(email);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        String token = jwtProvider.generateToken(authentication);

        // ✅ Trả về cả token, message, và maUser
        AuthResponse authResponse = new AuthResponse(token, "Signin Successful", user.getMaUser());

        return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
    }


    private Authentication authenticate(String email, String password) {
        UserDetails userDetails = customerUserServiceImp.loadUserByUsername(email);
        if (userDetails == null) {
            throw new BadCredentialsException("Invalid username or password");
        }
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid username or password");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }
}
