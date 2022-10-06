package com.example.getyourway.service;

import com.example.getyourway.entities.Subscription;
import com.example.getyourway.entities.User;
import com.example.getyourway.repositiories.SubscriptionRepo;
import com.example.getyourway.repositiories.UserRepo;
import com.stripe.Stripe;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.exception.StripeException;
import com.stripe.model.Event;
import com.stripe.model.SourceTransaction;
import com.stripe.model.StripeObject;
import com.stripe.model.checkout.Session;
import com.stripe.net.Webhook;
import com.stripe.param.checkout.SessionCreateParams;
import org.eclipse.jetty.util.ajax.JSON;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import spark.Spark;

import java.net.URI;
import java.util.*;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepo subscriptionRepo;

    @Autowired
    private UserRepo userRepo;

    public ResponseEntity<Void> webhook(String payload, String sigHeader){
        String endpointSecret = "whsec_e9d7889ef2bf5007a999ea445d1f861cde21a4824bfd81920c6bbcf1ecc501b1";
        Event event = null;
        try {
            event = Webhook.constructEvent(payload, sigHeader, endpointSecret);
        } catch (SignatureVerificationException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        String responseString = event.getData().getObject().toJson();
        JSONObject responseJSON = new JSONObject(responseString);
        String stripe_customer_id = responseJSON.get("customer").toString();

        switch (event.getType()) {
            case "checkout.session.completed":
                insertSubscription(responseJSON, stripe_customer_id);
                break;
            case "customer.subscription.deleted":
                deleteSubscription(responseJSON, stripe_customer_id);
                break;
            case "customer.subscription.updated":
                if(responseJSON.get("canceled_at") != null){
                    deleteSubscription(responseJSON, stripe_customer_id);
                } else {
                    insertSubscription(responseJSON, stripe_customer_id);
                }
                break;
            default:
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void insertSubscription(JSONObject responseJSON, String stripe_customer_id){

        int user_id = Integer.parseInt(responseJSON.getJSONObject("metadata").get("user_id").toString());
        Subscription s = new Subscription();
        s.setStripeId(stripe_customer_id);
        s.setStartDate(new Date()); //replace with event object date
        s.setEndDate(new Date()); //replace with event object date

        Optional<User> optional_user = userRepo.findById(user_id);
        if(optional_user.isPresent()){
            User current_user = optional_user.get();
            current_user.setSubscription(s);
            userRepo.save(current_user);
            subscriptionRepo.save(s);
        }
    }

    private void deleteSubscription(JSONObject responseJSON, String stripe_customer_id){
        if(responseJSON.get("canceled_at") != null){
            //delete
            List<Subscription> to_delete = subscriptionRepo.findSubscriptionsByStripeId(stripe_customer_id);
            if(to_delete.stream().count() > 0){
                subscriptionRepo.delete(to_delete.get(0));
            }
        }
    }

    public ResponseEntity<String> createSubscription(String userId) throws StripeException {
        Stripe.apiKey ="sk_test_51LiEeSJ1jIOYkwj9e80rbsjIrVIBRLFJaq1v0WgocMNGge4TTMWiJSZbN3pebdBXyeQyFmKr7gthfHVzHnWOzF0e00Y6xhE0AO";

        String priceId = "price_1LiFqUJ1jIOYkwj99CaiVlkS";
        SessionCreateParams params = new SessionCreateParams.Builder()
                .putMetadata("user_id", userId)
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
        return new ResponseEntity<>(session.getUrl().toString(), HttpStatus.OK);
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
