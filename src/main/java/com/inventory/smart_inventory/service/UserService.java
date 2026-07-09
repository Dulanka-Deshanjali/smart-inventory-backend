package com.inventory.smart_inventory.service;

import com.inventory.smart_inventory.entity.User;
import com.inventory.smart_inventory.repository.UserRepository;
import com.inventory.smart_inventory.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public User registerUser(User user) {

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("CASHIER");
        }
        return userRepository.save(user);
    }

    public String loginUser(User user){
        User existingUser = userRepository.findByUsername(user.getUsername())
                .orElseThrow(()-> new RuntimeException("Invalid User"));

        if (passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {

            return jwtService.generateToken(existingUser.getUsername());
        } else {

            throw new RuntimeException("Invalid Password");
        }
    }


}
