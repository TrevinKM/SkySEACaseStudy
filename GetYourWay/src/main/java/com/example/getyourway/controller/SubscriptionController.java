package com.example.getyourway.controller;

import com.example.getyourway.service.SubscriptionService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

    @Autowired
    SubscriptionService service;

    @PostMapping("/purchase")
    public ResponseEntity<Void> setCustomerID() throws StripeException {
        return service.createSubscription();
    }


    //TODO:Test this webhook on AWS
    @PostMapping("/webhook")
    public ResponseEntity<Void> subscriptionWebhook(@RequestBody String payload, @RequestHeader("Stripe-signature") String sigHeader) {
        return service.webhook(payload, sigHeader);
    }

    @GetMapping("/portal")
    public ResponseEntity<Void> loadCustomerPortal(@RequestParam String customer_id) throws StripeException {
        return service.getCustomerPortal(customer_id);
    }
}
