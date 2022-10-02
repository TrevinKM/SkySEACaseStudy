package com.example.getyourway.service;

import com.example.getyourway.DTOs.WeatherForecast;
import com.example.getyourway.exceptions.EndpointException;
import org.aspectj.lang.annotation.Before;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.engine.support.discovery.SelectorResolver;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import org.mockito.Matchers;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.net.URLEncoder;
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class WeatherServiceTest {
    @Mock
    RestTemplate template;
    @InjectMocks
    //@Autowired
    private WeatherService service;

    private final String validAddress = "Leeds";
    private final float validLon = 23;
    private final float validLat = 23;
    private final String validResponseJSON = "{\"location\":{\"currentConditions\": {temp:1.5, humidity:1.5, precip: 1.5}}}";
    private ResponseEntity<WeatherForecast> validWeatherResponse = new ResponseEntity<>(new WeatherForecast(1.5, 1.5, 1.5), HttpStatus.OK);

    @Test
    public void getCurrentWeatherAtLatLon_Returns_ValidWeatherForecastResponse() {
        ResponseEntity<WeatherForecast> validWeatherResponse = new ResponseEntity<>(new WeatherForecast(1.5, 1.5, 1.5), HttpStatus.OK);
        Mockito.when(template.exchange(
                Mockito.anyString(),
                Mockito.eq(HttpMethod.GET),
                Mockito.eq(null),
                Mockito.<Class<String>>any(),
                Mockito.anyString())).thenReturn(new ResponseEntity<String>(validResponseJSON, HttpStatus.OK));

        assertEquals("Valid response", validWeatherResponse, service.getCurrentWeatherAt(validLat, validLon));
    }

    public void getCurrentWeatherAtAddress_Returns_ValidWeatherForecastResponse() {
        Mockito.when(template.exchange(
                Mockito.anyString(),
                Mockito.eq(HttpMethod.GET),
                Mockito.eq(null),
                Mockito.<Class<String>>any(),
                Mockito.anyString())).thenReturn(new ResponseEntity<String>(validResponseJSON, HttpStatus.OK));

        assertEquals("Valid response", validWeatherResponse, service.getCurrentWeatherAt(validAddress));
    }
}