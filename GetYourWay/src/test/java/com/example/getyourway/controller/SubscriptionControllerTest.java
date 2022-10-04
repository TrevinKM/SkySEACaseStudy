package com.example.getyourway.controller;

import com.example.getyourway.service.SubscriptionService;
import com.example.getyourway.service.WeatherService;
import com.stripe.exception.StripeException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static reactor.core.publisher.Mono.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@AutoConfigureMockMvc
class SubscriptionControllerTest {

    @Mock
    RestTemplate template;

    @MockBean
    private SubscriptionService service;

    @InjectMocks
    @Autowired
    private SubscriptionController subscriptionController;

    @Autowired
    private MockMvc mockMvc;

    private final String baseURL = "/subscription";
    private final String createSubscriptionURL = baseURL + "/subscribe";

    private final String webhookURL = baseURL + "/webhook";
    private final String portalURL = baseURL + "/portal";

    @Test
    public void testCreateSubscription() throws Exception {
        Mockito.when(service.createSubscription()).thenReturn(new ResponseEntity<>(HttpStatus.OK));
        mockMvc.perform(post(createSubscriptionURL)).andExpect(status().isOk());
    }

    @Test
    public void testWebhook() throws Exception {
        Mockito.when(service.webhook(Mockito.anyString(), Mockito.anyString())).thenReturn(new ResponseEntity<>(HttpStatus.OK));
        mockMvc.perform(post(webhookURL).content("{\"payload\": null}").header("Stripe-signature", "")).andExpect(status().isOk());
    }

    @Test
    public void testCustomerPortal() throws Exception {
        Mockito.when(service.getCustomerPortal(Mockito.anyString())).thenReturn(new ResponseEntity<>(HttpStatus.OK));
        mockMvc.perform(get(portalURL).param("customer_id", Mockito.anyString())).andExpect(status().isOk());
    }

}