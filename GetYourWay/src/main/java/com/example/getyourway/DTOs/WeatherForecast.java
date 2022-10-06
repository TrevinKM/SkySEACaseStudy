package com.example.getyourway.DTOs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
public class WeatherForecast {
    @JsonCreator
    public WeatherForecast(@JsonProperty(value = "temp", required = true) double temp, @JsonProperty(value = "precip") double precip, @JsonProperty(value = "humidity") double humidity) {
        this.temp = temp;
        this.precip = precip;
        this.humidity = humidity;

    }

    @JsonProperty(value = "temp", required = true)
    private double temp;
    @NotNull
    private double humidity;
    @NotNull
    private double precip;
}