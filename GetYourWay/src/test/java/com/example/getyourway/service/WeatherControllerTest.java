package com.example.getyourway.service;

import com.example.getyourway.DTOs.WeatherForecast;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class WeatherControllerTest {

    @Mock
    private RestTemplate restTemplate;

    @Autowired
    WeatherService service = new WeatherService();

    WeatherForecast validForecast = new WeatherForecast(2.3, 4.5, 9.6);

    @Test
    public void testGetWeatherAt() {

    }
}
