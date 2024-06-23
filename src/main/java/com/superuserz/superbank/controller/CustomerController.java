package com.superuserz.superbank.controller;


import com.superuserz.superbank.request.SignupRequest;
import com.superuserz.superbank.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {


    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private SignupService signupService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody SignupRequest signupRequest) {

            signupRequest.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
            String response = signupService.register(signupRequest);
            ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.OK)
                    .body(response);
            return responseEntity;
    }
}
