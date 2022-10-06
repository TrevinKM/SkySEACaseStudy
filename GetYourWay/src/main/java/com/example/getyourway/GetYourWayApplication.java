package com.example.getyourway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.port;
import static spark.Spark.staticFiles;
@SpringBootApplication
public class GetYourWayApplication {


    @Bean
    public RestTemplate getResTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {

        SpringApplication.run(GetYourWayApplication.class, args);

    }

}
