package com.example.getyourway.service;

import com.example.getyourway.DTOs.Location;
import com.example.getyourway.DTOs.Response;
import com.example.getyourway.DTOs.Weather;
import com.example.getyourway.DTOs.WeatherForecast;
import com.example.getyourway.controller.APIController;
import com.example.getyourway.controller.WeatherController;
import com.example.getyourway.exceptions.IncompatibleResponseException;
import com.example.getyourway.exceptions.InvalidCoordException;
import com.example.getyourway.exceptions.InvalidDateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@AutoConfigureMockMvc
class APIControllerTest {
    @Mock
    RestTemplate template;

    @MockBean
    private APIService service;

    @InjectMocks
    @Autowired
    private APIController apiController;

    @Autowired
    private MockMvc mockMvc;

    final String baseURL = "/api";
    final String getCurrentLocationURL = baseURL + "/location";

    @Test
    public void contextLoads() { assertThat(apiController).isNotNull(); }

    @Test
    public void getCurrentLocation_Should_Return_OK() throws Exception {
        ResponseEntity<Response> response = new ResponseEntity<>(new Response((new Location(0.0,0.0)),0.0), HttpStatus.OK);
        when(service.findCurrentLocation()).thenReturn(response);
        mockMvc.perform(get(getCurrentLocationURL)).andExpect(status().isOk());
    }

}
