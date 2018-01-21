package com.example.demo.controller;

import com.example.demo.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("${info.api.base-path}" + "/auth")
@RestController
public class AuthenticationController {

            /*
            TRY WITH CURL: curl http://localhost:8080/v1/app/auth/login -X POST -d "username=crmadmin&password=adminpass"
             */
    @RequestMapping(value = {"/login"},method = RequestMethod.POST)
    public ResponseEntity<?>  login(@RequestParam("username") String username, @RequestParam("password") String password){
        return new ResponseEntity<>(username, HttpStatus.OK);
    }
}
