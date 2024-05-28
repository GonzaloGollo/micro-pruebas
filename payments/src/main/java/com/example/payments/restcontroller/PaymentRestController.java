package com.example.payments.restcontroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/payments")
public class PaymentRestController {

    @PostMapping()
    public void createPayment(){

    }


}
