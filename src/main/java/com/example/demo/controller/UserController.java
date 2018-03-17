package com.example.demo.controller;


import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("${info.api.base-path}")
@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = {"/register"},method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User user){
        if(!userExist(user.getUsername())){
            userRepository.save(user);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
       throw new IllegalArgumentException("This user "+ user.getUsername()+ "already exist");
    }

    private boolean userExist(String username) {
        if(Optional.ofNullable(userRepository.findByUsername(username)).isPresent()){
            return true;
        }
        return false;
    }
}
