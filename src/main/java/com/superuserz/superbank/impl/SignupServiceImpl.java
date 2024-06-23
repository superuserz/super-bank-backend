package com.superuserz.superbank.impl;

import com.superuserz.superbank.entity.Customer;
import com.superuserz.superbank.repository.CustomerRepository;
import com.superuserz.superbank.request.SignupRequest;
import com.superuserz.superbank.service.SignupService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignupServiceImpl implements SignupService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public String register(SignupRequest request) {

        if (request == null
                || StringUtils.isBlank(request.getEmail())
                || StringUtils.isBlank(request.getPassword())
                || StringUtils.isBlank(request.getRole())) {

            return "Please send a valid request";
        }

        if(customerRepository.findByEmail(request.getEmail()).size() > 0) {
            return "You are already registered";
        }
        Customer customer = new Customer();
        customer.setEmail(request.getEmail().trim());
        customer.setPassword(request.getPassword().trim());
        customer.setRole(request.getRole().trim());

        Customer response = customerRepository.save(customer);
        if(response != null) {
            return "Customer " + response.getEmail() + " has been successfully registered";
        }
        return "Unable to register customer. Please check logs for further details";
    }
}
