package com.example.demo.service;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class SignupService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    /**
     *
     * set up a default customer with two roles USER and ADMIN
     *
     */
    @PostConstruct
    private void setupDefaultUser() {
        //-- just to make sure there is an ADMIN user exist in the database for testing purpose
        if (userRepository.count() == 0) {
            Role roleUser= new Role("USER");
            Role roleAdmin= new Role("ADMIN");
            roleRepository.save(roleUser);
            roleRepository.save(roleAdmin);
            userRepository.save(new User("admin",
                    passwordEncoder.encode("pass"),
                    Arrays.asList(roleAdmin,roleUser)));
        }
    }

}
