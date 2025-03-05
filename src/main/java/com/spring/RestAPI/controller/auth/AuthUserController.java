package com.spring.RestAPI.controller.auth;

import com.spring.RestAPI.dto.AuthUserDTO;
import com.spring.RestAPI.dto.LoginDTO;
import com.spring.RestAPI.dto.LoginResponseDto;
import com.spring.RestAPI.model.AuthUser;
import com.spring.RestAPI.repository.AuthUserRepository;
import com.spring.RestAPI.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthUserController {

    private final AuthUserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;  // Inject JwtUtil

    public AuthUserController(AuthUserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.jwtUtil = jwtUtil;
    }

    public String registerUser(AuthUserDTO userDTO) {
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            return "Email is already in use.";
        }

        AuthUser user = new AuthUser();
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword())); // Encrypt password

        userRepository.save(user);
        return "User registered successfully!";
    }

    // Ensure that this method is correctly used in your Controller.
    public LoginResponseDto loginUser(LoginDTO loginDto) {
        Optional<AuthUser> userOptional = userRepository.findByEmail(loginDto.getEmail());

        if (userOptional.isEmpty()) {
            return new LoginResponseDto("User not found!", null);
        }

        AuthUser user = userOptional.get();

        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            return new LoginResponseDto("Invalid email or password!", null);
        }

        // Generate JWT token
        String token = jwtUtil.generateToken(user.getEmail());

        return new LoginResponseDto("Login successful!", token);
    }
}
