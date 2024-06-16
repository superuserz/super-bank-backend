package com.superuserz.superbank.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @GetMapping("/transaction")
    public String getTrasactions() {
        return "called transactions";
    }
}
