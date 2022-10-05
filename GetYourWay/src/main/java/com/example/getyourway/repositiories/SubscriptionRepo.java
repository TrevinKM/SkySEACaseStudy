package com.example.getyourway.repositiories;

import com.example.getyourway.entities.Subscription;
import com.example.getyourway.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription, Integer> {
    List<Subscription> findSubscriptionsByStripeId(String stripeId);
}
