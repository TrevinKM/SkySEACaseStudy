package com.example.getyourway.service;

import com.example.getyourway.DTOs.Weather;
import com.example.getyourway.DTOs.WeatherForecast;
import com.example.getyourway.controller.WeatherController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class WeatherControllerTest {

    @Mock
    private RestTemplate restTemplate;

    @Autowired
    WeatherService service = new WeatherService();

    WeatherForecast validForecast = new WeatherForecast(2.3, 4.5,9.6);;

    @Test
    public void testGetWeatherAt(){

   }
}
