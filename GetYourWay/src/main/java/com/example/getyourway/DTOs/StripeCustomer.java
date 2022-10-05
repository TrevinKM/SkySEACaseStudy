package com.example.getyourway.DTOs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
public class StripeCustomer {
    private int user_id;

    @JsonCreator
    public StripeCustomer(@JsonProperty(value = "user_id", required = true) int user_id) {
        this.user_id = user_id;

    }

}