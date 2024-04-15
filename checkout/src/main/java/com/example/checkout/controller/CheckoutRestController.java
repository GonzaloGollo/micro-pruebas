package com.example.checkout.controller;

import com.example.checkout.model.Checkout;
import com.example.checkout.service.ICheckoutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/checkout")
public class CheckoutRestController {

private ICheckoutService checkoutService;


    public CheckoutRestController(ICheckoutService checkoutService) {
        super();
        this.checkoutService = checkoutService;
    }

    @GetMapping()
    public Checkout getCheckout(@RequestParam List<String> productsIds, @RequestHeader("X-Request-from") String requestFrom, @RequestHeader() Map<String, String> headers ){
        System.out.println("Enviado desde: " + requestFrom);
        if (!requestFrom.equals("gateway")){
            return null;
        }
        return checkoutService.buildCheckout(productsIds);
    }

}
