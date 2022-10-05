package com.example.getyourway.DTOs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "address_components",
        "formatted_address",
        "geometry",
        "place_id",
        "plus_code",
        "types"
})
@Generated("jsonschema2pojo")
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    @JsonProperty("address_components")
    private List<Object> addressComponents = null;
    @JsonProperty("formatted_address")
    private String formattedAddress;
    @JsonProperty("geometry")
    private Object geometry;
    @JsonProperty("place_id")
    private String placeId;
    @JsonProperty("plus_code")
    private Object plusCode;
    @JsonProperty("types")
    private List<String> types = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("address_components")
    public List<Object> getAddressComponents() {
        return addressComponents;
    }

    @JsonProperty("address_components")
    public void setAddressComponents(List<Object> addressComponents) {
        this.addressComponents = addressComponents;
    }

    @JsonProperty("formatted_address")
    public String getFormattedAddress() {
        return formattedAddress;
    }

    @JsonProperty("formatted_address")
    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    @JsonProperty("geometry")
    public Object getGeometry() {
        return geometry;
    }

    @JsonProperty("geometry")
    public void setGeometry(Object geometry) {
        this.geometry = geometry;
    }

    @JsonProperty("place_id")
    public String getPlaceId() {
        return placeId;
    }

    @JsonProperty("place_id")
    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    @JsonProperty("plus_code")
    public Object getPlusCode() {
        return plusCode;
    }

    @JsonProperty("plus_code")
    public void setPlusCode(Object plusCode) {
        this.plusCode = plusCode;
    }

    @JsonProperty("types")
    public List<String> getTypes() {
        return types;
    }

    @JsonProperty("types")
    public void setTypes(List<String> types) {
        this.types = types;
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