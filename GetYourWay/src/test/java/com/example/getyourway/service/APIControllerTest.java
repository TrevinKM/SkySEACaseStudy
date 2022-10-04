package com.example.getyourway.service;

import com.example.getyourway.DTOs.Location;
import com.example.getyourway.DTOs.Response;
import com.example.getyourway.DTOs.Result;
import com.example.getyourway.controller.APIController;
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

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    final String getAddressURL = baseURL + "/address?lat=40.714224&lng=-73.961452";

    @Test
    public void contextLoads() { assertThat(apiController).isNotNull(); }

    @Test
    public void getCurrentLocation_Should_Return_OK() throws Exception {
        ResponseEntity<Response> response = new ResponseEntity<>(new Response((new Location(0.0,0.0)),0.0), HttpStatus.OK);
        when(service.findCurrentLocation()).thenReturn(response);
        mockMvc.perform(get(getCurrentLocationURL)).andExpect(status().isOk());
    }
    @Test
    public void getAddress_Should_Return_OK() throws Exception {
        ResponseEntity<Result> response = new ResponseEntity<>(new Result(Collections.emptyList(),"address", new Object(), "placeid", new Object(), Collections.<String>emptyList(), Collections.emptyMap()), HttpStatus.OK);
        when(service.findReverseGeolocation(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(response);
        mockMvc.perform(get(getAddressURL)).andExpect(status().isOk());
    }

}
