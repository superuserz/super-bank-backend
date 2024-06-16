package com.superuserz.superbank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    @GetMapping("/card")
    public String getCardDetails() {
        return "Called CardController.getCardDetails()";
    }

}
