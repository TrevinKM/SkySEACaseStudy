package com.example.getyourway.DTOs;


import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "bounds",
        "location",
        "location_type",
        "viewport"
})
@Generated("jsonschema2pojo")
public class Geometry {

    @JsonProperty("bounds")
    private Object bounds;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("location_type")
    private String locationType;
    @JsonProperty("viewport")
    private Object viewport;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("bounds")
    public Object getBounds() {
        return bounds;
    }

    @JsonProperty("bounds")
    public void setBounds(Object bounds) {
        this.bounds = bounds;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("location_type")
    public String getLocationType() {
        return locationType;
    }

    @JsonProperty("location_type")
    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    @JsonProperty("viewport")
    public Object getViewport() {
        return viewport;
    }

    @JsonProperty("viewport")
    public void setViewport(Object viewport) {
        this.viewport = viewport;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}