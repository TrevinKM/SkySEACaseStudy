import React from 'react';
import { useState } from 'react';
import { GoogleMap, LoadScript, DirectionsRenderer, useJsApiLoader, Marker, Polyline } from '@react-google-maps/api';

//const google = window.google;

const startDestLat = 1
const startDestLng = 1

const endDestLat = 40.7128
const endDestLng = -74.0060

var centerLat = (startDestLat + endDestLat)/2
var centerLng = (startDestLng + endDestLng)/2

const containerStyle = {
    width: '400px',
    height: '400px'
};

const startDestination = {
    lat: startDestLat,
    lng: startDestLng
}

const endDestination = {
    lat: endDestLat,
    lng: endDestLng
}

const flightPath = [
    {lat: startDestLat, lng: startDestLng},
    {lat: endDestLat, lng: endDestLng}
]

const center = {
    lat: centerLat,
    lng: centerLng
};

//const directionsService = new window.google.maps.DirectionsService();

//const origin = 'Leicester';
//const destination = 'Stansted';
//const results = directionsService.route({
//    origin: origin,
//    destination: destination,
//    travelMode: window.google.maps.TravelMode.DRIVING
//})

//This code goes in the html return stuff but not working >:( so just putting here in case I need it
//{directionsResponse && (
//    <DirectionsRenderer directions={directionsResponse} />
//)}

function MapsAPITest() {
    const { isLoaded } = useJsApiLoader({
        googleMapsApiKey: "AIzaSyD9T7Iz3AHsGMeGNprGoIojX6CHfbuF4EE"
    })

    const [directionsResponse, setDirectionsResponse] = useState(null)

    //eslint-disable-next-line no-undef
    //var map = new window.google.maps.Map(document.getElementById('map_canvas'), mapOptions);
    //setDirectionsResponse(results)
    
    return (
        <>
        <LoadScript googleMapsApiKey="AIzaSyD9T7Iz3AHsGMeGNprGoIojX6CHfbuF4EE">
            <GoogleMap
                mapContainerStyle={containerStyle}
                center={center}
                zoom={2}>
                <></>
                
                <Marker position={startDestination} />
                <Marker position={endDestination} />
                <Polyline path={flightPath} />
            </GoogleMap>
        </LoadScript>
        </>
    )
}

export default React.memo(MapsAPITest);