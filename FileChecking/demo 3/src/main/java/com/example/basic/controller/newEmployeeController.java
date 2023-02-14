package com.example.basic.controller;

import com.example.basic.entity.AuthRequest;
import com.example.basic.entity.Employee;
import com.example.basic.entity.User;
import com.example.basic.service.employeeservice;
import com.example.basic.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class newEmployeeController {

    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody AuthRequest authRequest){
        Authentication authentication = (authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword())));
        if (authentication.isAuthenticated()) {
            return jwtUtil.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }


    }

    @GetMapping("/gogo")
    public String hello(){
        return "go india";
    }



}

