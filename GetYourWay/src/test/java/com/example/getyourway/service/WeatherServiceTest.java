package com.example.getyourway.service;

import com.example.getyourway.DTOs.WeatherForecast;
import com.example.getyourway.exceptions.IncompatibleResponseException;
import com.example.getyourway.exceptions.InvalidCoordException;
import com.example.getyourway.exceptions.InvalidDateException;
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

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.springframework.http.RequestEntity.post;
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
    private final float validLon = 180, validLat = 90, invalidLon = -181, invalidLat = -91;
    private final String validWeatherJSON = "{\"location\":{\"currentConditions\": {temp:1.5, humidity:1.5, precip: 1.5}}}";
    private final String invalidWeatherJSON = "{\"location\":{\"currentConditions\": {not_temp:1.5, not_humidity:1.5, not_precip: 1.5}}}";
    private final ResponseEntity<WeatherForecast> validWeatherResponse = new ResponseEntity<>(new WeatherForecast(1.5, 1.5, 1.5), HttpStatus.OK);
    private final List<WeatherForecast> forecastList = new ArrayList<>();

    @Test
    public void getCurrentWeatherAtLatLon_Returns_ValidWeatherForecastResponse() {
        ResponseEntity<WeatherForecast> validWeatherResponse = new ResponseEntity<>(new WeatherForecast(1.5, 1.5, 1.5), HttpStatus.OK);

        Mockito.when(template.exchange(
                Mockito.anyString(),
                Mockito.eq(HttpMethod.GET),
                Mockito.eq(null),
                Mockito.<Class<String>>any(),
                Mockito.anyString())).thenReturn(new ResponseEntity<>(validWeatherJSON, HttpStatus.OK));

        assertEquals("Valid response", validWeatherResponse, service.getCurrentWeatherAt(validLat, validLon));
    }

    @Test
    public void getCurrentWeatherAtAddress_Returns_ValidWeatherForecastResponse() {
        Mockito.when(template.exchange(
                Mockito.anyString(),
                Mockito.eq(HttpMethod.GET),
                Mockito.eq(null),
                Mockito.<Class<String>>any(),
                Mockito.anyString())).thenReturn(new ResponseEntity<>(validWeatherJSON, HttpStatus.OK));

        assertEquals("Valid response", validWeatherResponse, service.getCurrentWeatherAt(validAddress));
    }

    @Test
    public void getForecastWeatherAtAddress_Returns_ValidWeatherForecastResponse() {
        Date yesterday = Date.from(Instant.now().minus(1, ChronoUnit.DAYS));
        String response = "{\n" +
                "  \"days\": [\n" +
                "    {\n" +
                "      \"temp\": 1.5,\n" +
                "      \"dew\": 47.7,\n" +
                "      \"humidity\": 1.5,\n" +
                "      \"precip\": 1.5,\n" +
                "      \"precipprob\": null,\n" +
                "      \"precipcover\": 4.17,\n" +
                "      \"preciptype\": null,\n" +
                "      \"snow\": 0.0,\n" +
                "      \"snowdepth\": 0.0,\n" +
                "      \"windgust\": null,\n" +
                "      \"windspeed\": 10.7,\n" +
                "      \"winddir\": 230.4,\n" +
                "      \"pressure\": 997.6,\n" +
                "      \"cloudcover\": 0.5,\n" +
                "      \"visibility\": 20.5,\n" +
                "      \"solarradiation\": 88.3,\n" +
                "      \"solarenergy\": 3.8,\n" +
                "      \"uvindex\": 3.0,\n" +
                "      \"sunrise\": \"07:01:42\",\n" +
                "      \"sunriseEpoch\": 1601532102,\n" +
                "      \"sunset\": \"18:37:27\",\n" +
                "      \"sunsetEpoch\": 1601573847,\n" +
                "      \"moonphase\": 0.5,\n" +
                "      \"conditions\": \"Rain\",\n" +
                "      \"description\": \"Clear conditions throughout the day with early morning rain.\",\n" +
                "      \"icon\": \"rain\",\n" +
                "      \"source\": \"obs\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        Mockito.when(template.exchange(
                Mockito.anyString(),
                Mockito.eq(HttpMethod.GET),
                Mockito.eq(null),
                Mockito.<Class<String>>any(),
                Mockito.anyString())).thenReturn(new ResponseEntity<>(response, HttpStatus.OK));
        forecastList.add(new WeatherForecast(1.5, 1.5, 1.5));
        assertEquals("Valid response", new ResponseEntity<List<WeatherForecast>>(forecastList, HttpStatus.OK), service.getForecastWeatherAt(yesterday, new Date(), validAddress));
    }

    @Test
    public void getCurrentWeatherAtInvalidLat_Returns_InvalidCoordException() {
        assertThrows(InvalidCoordException.class,
                () -> service.getCurrentWeatherAt(invalidLat, validLon));
        verify(template, never()).exchange(
                Mockito.anyString(),
                Mockito.eq(HttpMethod.GET),
                Mockito.eq(null),
                Mockito.<Class<String>>any(),
                Mockito.anyString());
    }

    @Test
    public void getCurrentWeatherAtInvalidLon_Returns_InvalidCoordException() {
        assertThrows(InvalidCoordException.class,
                () -> {
                    service.getCurrentWeatherAt(validLat, invalidLon);
                });
        verify(template, never()).exchange(
                Mockito.anyString(),
                Mockito.eq(HttpMethod.GET),
                Mockito.eq(null),
                Mockito.<Class<String>>any(),
                Mockito.anyString());
    }

    @Test
    public void getCurrentWeatherAtInvalidDate_Returns_InvalidDateException() {
        Date yesterday = Date.from(Instant.now().minus(1, ChronoUnit.DAYS));

        assertThrows(InvalidDateException.class,
                () -> {
                    service.getForecastWeatherAt(new Date(), yesterday, validAddress);
                });
        verify(template, never()).exchange(
                Mockito.anyString(),
                Mockito.eq(HttpMethod.GET),
                Mockito.eq(null),
                Mockito.<Class<String>>any(),
                Mockito.anyString());
    }

    @Test
    public void getCurrentWeatherAtInvalidJSON_Returns_IncompatibleResponseException() {
        Mockito.when(template.exchange(
                Mockito.anyString(),
                Mockito.eq(HttpMethod.GET),
                Mockito.eq(null),
                Mockito.<Class<String>>any(),
                Mockito.anyString())).thenReturn(new ResponseEntity<>(invalidWeatherJSON, HttpStatus.OK));


        assertThrows(IncompatibleResponseException.class,
                () -> {
                    service.getCurrentWeatherAt(validLat, validLon);
                });

    }

}