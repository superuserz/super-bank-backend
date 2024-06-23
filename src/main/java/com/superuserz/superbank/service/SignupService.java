package com.superuserz.superbank.service;

import com.superuserz.superbank.request.SignupRequest;
import org.springframework.stereotype.Service;

@Service
public interface SignupService {

    public String register(SignupRequest request);
}
