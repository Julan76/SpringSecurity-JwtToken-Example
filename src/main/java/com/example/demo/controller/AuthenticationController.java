package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("${info.api.base-path}" + "/auth")
@RestController
public class AuthenticationController {
            /*
            curl trusted-app:secret@localhost:8080/oauth/token -d "grant_type=password&username=user&password=password"

             */

            /*
            TRY WITH CURL: curl http://localhost:8080/v1/app/auth/login -X POST -d "username=crmadmin&password=adminpass"
             */
    @RequestMapping(value = {"/login"},method = RequestMethod.POST)
    public ResponseEntity<?>  login(@RequestParam("username") String username, @RequestParam("password") String password){
        System.out.println("YAYYAYAY");
        System.out.println("user "+username+ " pass "+password);
        return new ResponseEntity<>(username, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/test")
    public void  test(@RequestParam("username") String username, @RequestParam("password") String password){
        System.out.println("YAYYAYAY");
        System.out.println("user "+username+ " pass "+password);
        System.out.println("noo");
    }
}
