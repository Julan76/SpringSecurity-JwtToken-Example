package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RequestMapping("${info.api.base-path}" + "/test")
@RestController
public class TestController {
    @RequestMapping("/test")
    public void  test(@RequestParam("username") String username, @RequestParam("password") String password){
        System.out.println("user "+username+ " pass "+password);
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        System.out.println(authorities);
    }
}
