import React from 'react';
import { useState } from 'react';
import { GoogleMap, LoadScript, DirectionsRenderer, useJsApiLoader, Marker, Polyline } from '@react-google-maps/api';
import axios from 'axios';
import Geocode from "react-geocode"

//const google = window.google;

/*const startDestLat = 1
const startDestLng = 1

const endDestLat = 40.7128
const endDestLng = -74.0060

var centerLat = (startDestLat + endDestLat)/2
var centerLng = (startDestLng + endDestLng)/2*/

const containerStyle = {
    width: '400px',
    height: '400px'
};

Geocode.setApiKey("AIzaSyD9T7Iz3AHsGMeGNprGoIojX6CHfbuF4EE")
Geocode.enableDebug()

/*const startDestination = {
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
]*/

/*const center = {
    lat: centerLat,
    lng: centerLng
};*/

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

function MapsAPITest(props) {

    console.log(props.origin);
    console.log(props.destination);


    const startIataCode = 'Airport ' + props.origin
    const endIataCode = 'Airport ' + props.destination

    const [startDestinationLatitude, setStartDestinationLatitude] = useState(0);
    const [startDestinationLongitude, setStartDestinationLongitude] = useState(0);

    const [endDestinationLatitude, setEndDestinationLatitude] = useState(0);
    const [endDestinationLongitude, setEndDestinationLongitude] = useState(0);

    //Gets Json from google geocode api, need to work out how to import startIataCode from Trev
    /*let startPayload = {address: startIataCode, key: 'AIzaSyD9T7Iz3AHsGMeGNprGoIojX6CHfbuF4EE'}
    const startParams = new URLSearchParams(startPayload)
    var startDestinationJson = axios.get(`https://maps.googleapis.com/maps/api/geocode/json?${startParams}`)
    */
    //Same as above but for end destination
    /*let endPayload = {address: endIataCode, key: 'AIzaSyD9T7Iz3AHsGMeGNprGoIojX6CHfbuF4EE'}
    const endParams = new URLSearchParams(endPayload)
    var endDestinationJson = axios.get(`https://maps.googleapis.com/maps/api/geocode/json?${endParams}`)
    */

    Geocode.fromAddress(startIataCode).then(
        (response) => {
            const startDestinationLatitude = response.results[0].geometry.location.lat;
            setStartDestinationLatitude(startDestinationLatitude)
            console.log(startDestinationLatitude)
        },
        (error) => {
            console.error(error)
        }
    )

    Geocode.fromAddress(startIataCode).then(
        (response) => {
            const startDestinationLongitude = response.results[0].geometry.location.lng;
            setStartDestinationLongitude(startDestinationLongitude)
        },
        (error) => {
            console.error(error)
        }
    )

    Geocode.fromAddress(endIataCode).then(
        (response) => {
            const endDestinationLatitude = response.results[0].geometry.location.lat;
            setEndDestinationLatitude(endDestinationLatitude)
        },
        (error) => {
            console.error(error)
        }
    )

    Geocode.fromAddress(endIataCode).then(
        (response) => {
            const endDestinationLongitude = response.results[0].geometry.location.lng;
            setEndDestinationLongitude(endDestinationLongitude)
        },
        (error) => {
            console.error(error)
        }
    )

    //Sets start destination lat and long from JSON result
    /*var startDestinationLatitude = response.results[0].geometry.location.map(x => x.lat)
    var startDestinationLongitude = response.results[0].geometry.location.map(x => x.lng)*/

    //Sets end destination lat and long from JSON result
    /*var endDestinationLatitude = response.results[1].geometry.location.map(x => x.lat)
    var endDestinationLongitude = response.results[1].geometry.location.map(x => x.lng)*/

    //const startDestinationLatitude = startDestination.map(x => x.lat)
    //const startDestinationLongitude = startDestination.map(x => x.lng)

    //const endDestinationLatitude = endDestination.map(x => x.lat)
    //const endDestinationLongitude = endDestination.map(x => x.lng)

    //Sets center to be mid point between both start and end
    var centerLatitude = (startDestinationLatitude + endDestinationLatitude)/2
    var centerLongitude = (startDestinationLongitude + endDestinationLongitude)/2

    var center = {
        lat: centerLatitude,
        lng: centerLongitude
    }

    var startDestination = {
        lat: startDestinationLatitude,
        lng: startDestinationLongitude
    }

    var endDestination = {
        lat: endDestinationLatitude,
        lng: endDestinationLongitude
    }

    var flightPath = [
        {lat: startDestinationLatitude, lng: startDestinationLongitude},
        {lat: endDestinationLatitude, lng: endDestinationLongitude}
    ]

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