package com.example.getyourway.service;

import com.stripe.Stripe;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.exception.StripeException;
import com.stripe.model.Event;
import com.stripe.model.checkout.Session;
import com.stripe.net.Webhook;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class SubscriptionService {
    public ResponseEntity<Void> webhook(String payload, String sigHeader){
        String endpointSecret = "whsec_PEvZgyzKRbbeMlaFFZ8zbR9UNLe3aokA";

        Event event = null;

        try {
            event = Webhook.constructEvent(payload, sigHeader, endpointSecret);
        } catch (SignatureVerificationException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        switch (event.getType()) {
            case "checkout.session.completed":
                //Add customer id to user
                break;
            case "customer.subscription.deleted":
                // Delete customer id
                break;
            case "invoice.paid":
                break;
            case "invoice.payment_failed":
                break;
            default:
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Void> createSubscription() throws StripeException {
        Stripe.apiKey ="sk_test_51LiEeSJ1jIOYkwj9e80rbsjIrVIBRLFJaq1v0WgocMNGge4TTMWiJSZbN3pebdBXyeQyFmKr7gthfHVzHnWOzF0e00Y6xhE0AO";

        String priceId = "price_1LiFqUJ1jIOYkwj99CaiVlkS";
        SessionCreateParams params = new SessionCreateParams.Builder()
                .setSuccessUrl("https://example.com/success.html?session_id={CHECKOUT_SESSION_ID}")
                .setCancelUrl("https://example.com/canceled.html")
                .setMode(SessionCreateParams.Mode.SUBSCRIPTION)
                .addLineItem(new SessionCreateParams.LineItem.Builder()
                        // For metered billing, do not pass quantity
                        .setQuantity(1L)
                        .setPrice(priceId)
                        .build()
                )
                .build();

        Session session = Session.create(params);
        return ResponseEntity.status(HttpStatus.SEE_OTHER).location(URI.create(session.getUrl())).build();
    }
    public ResponseEntity<Void> getCustomerPortal(String customer_id) throws StripeException{
        Stripe.apiKey ="sk_test_51LiEeSJ1jIOYkwj9e80rbsjIrVIBRLFJaq1v0WgocMNGge4TTMWiJSZbN3pebdBXyeQyFmKr7gthfHVzHnWOzF0e00Y6xhE0AO";

        com.stripe.param.billingportal.SessionCreateParams params = new com.stripe.param.billingportal.SessionCreateParams.Builder()
                .setReturnUrl("http://localhost:8082")
                .setCustomer(customer_id)
                .build();
        com.stripe.model.billingportal.Session portalSession = com.stripe.model.billingportal.Session.create(params);

        return ResponseEntity.status(HttpStatus.SEE_OTHER).location(URI.create(portalSession.getUrl())).build();
    }
}
