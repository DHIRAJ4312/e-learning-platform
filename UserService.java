package com.example.elearning.service;

import com.example.elearning.model.User;
import com.example.elearning.model.Role;
import com.example.elearning.repository.UserRepository;
import com.example.elearning.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User register(User u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        if (u.getRole() == null) u.setRole(Role.STUDENT);
        return userRepository.save(u);
    }

    public Optional<String> login(String email, String rawPassword) {
        Optional<User> opt = userRepository.findByEmail(email);
        if (opt.isEmpty()) return Optional.empty();
        User user = opt.get();
        if (passwordEncoder.matches(rawPassword, user.getPassword())) {
            String token = jwtUtil.generateToken(user.getEmail());
            return Optional.of(token);
        } else {
            return Optional.empty();
        }
    }
}
