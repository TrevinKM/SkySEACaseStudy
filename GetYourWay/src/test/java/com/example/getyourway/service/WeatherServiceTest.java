package com.example.getyourway.service;

import com.example.getyourway.DTOs.WeatherForecast;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.util.AssertionErrors.assertEquals;

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
    private final ResponseEntity<WeatherForecast> validWeatherResponse = new ResponseEntity<>(new WeatherForecast(1.5, 1.5, 1.5), HttpStatus.OK);

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