package com.superuserz.superbank.impl;

import com.superuserz.superbank.entity.Customer;
import com.superuserz.superbank.repository.CustomerRepository;
import com.superuserz.superbank.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserManagementServiceImpl implements UserManagementService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Integer customerId = null;
        String password = null;
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<Customer> customerList = customerRepository.findByEmail(username.trim());
        if(customerList.size() == 0) {
            throw new UsernameNotFoundException(username);
        } else {
            customerId = customerList.get(0).getCustomerId();
            password = customerList.get(0).getPassword();
            authorities.add(new SimpleGrantedAuthority(customerList.get(0).getRole()));
        }
        return new User(username, password, authorities);
    }
}
