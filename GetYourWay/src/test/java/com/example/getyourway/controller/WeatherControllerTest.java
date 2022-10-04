package com.example.getyourway.controller;

import com.example.getyourway.DTOs.WeatherForecast;
import com.example.getyourway.controller.WeatherController;
import com.example.getyourway.service.WeatherService;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@AutoConfigureMockMvc
class WeatherControllerTest {
    @Mock
    RestTemplate template;

    @MockBean
    private WeatherService service;
    @InjectMocks
    @Autowired
    private WeatherController weatherController;

    @Autowired
    private MockMvc mockMvc;
    final String baseUrl = "/weather";
    final String getCurrentWeatherAtURL = baseUrl + "/current?location=bradford";
    final String getCurrentWeatherAtLatLonURL = baseUrl + "/current?lat=23&lon=23";

    final String getForecastWeatherAtURL = baseUrl + "/timeline?startdate=2021-02-01&enddate=2021-02-02&location=bradford";
    final String invalidForecastWeatherAtURL = baseUrl + "/timeline?startdate=20Y3-02-01&enddate=2021-02-02&location=bradford";

    @Test
    public void contextLoads() {
        assertThat(weatherController).isNotNull();
    }

    @Test
    public void getCurrentWeatherAtAddress_Should_ReturnOK() throws Exception {
        ResponseEntity<WeatherForecast> response = new ResponseEntity<>(new WeatherForecast(1.5, 1.5, 1.5), HttpStatus.OK);
        when(service.getCurrentWeatherAt(Mockito.anyString())).thenReturn(response);
        mockMvc.perform(get(getCurrentWeatherAtURL)).andExpect(status().isOk());
    }

    @Test
    public void getForecastWeatherAtALatLon_Should_ReturnOK() throws Exception {
        List<WeatherForecast> days = new ArrayList<>();
        WeatherForecast response = new WeatherForecast(1.5, 1.5, 1.5);
        days.add(response);
        when(service.getForecastWeatherAt(any(Date.class), any(Date.class), Mockito.anyString())).thenReturn(new ResponseEntity<>(days, HttpStatus.OK));
        mockMvc.perform(get(getForecastWeatherAtURL)).andExpect(status().isOk());
    }

    @Test
    public void getCurrentWeatherAtLatLon_Should_ReturnOK() throws Exception {
        List<WeatherForecast> days = new ArrayList<>();
        WeatherForecast response = new WeatherForecast(1.5, 1.5, 1.5);
        days.add(response);
        when(service.getForecastWeatherAt(any(Date.class), any(Date.class), Mockito.anyString())).thenReturn(new ResponseEntity<>(days, HttpStatus.OK));
        mockMvc.perform(get(getCurrentWeatherAtLatLonURL)).andExpect(status().isOk());
    }

    @Test
    public void getForecastWeatherAt_InvalidDate_ShouldThrow_InvalidDateException() throws Exception {
        List<WeatherForecast> days = new ArrayList<>();
        WeatherForecast response = new WeatherForecast(1.5, 1.5, 1.5);
        days.add(response);
        when(service.getForecastWeatherAt(any(Date.class), any(Date.class), Mockito.anyString())).thenReturn(new ResponseEntity<>(days, HttpStatus.OK));
        mockMvc.perform(get(invalidForecastWeatherAtURL)).andExpect(status().isBadRequest());
    }

}