import React from "react";
import axios from "axios";
import { useEffect } from "react";
import { useState } from "react";
//import SavedJourney from "./SavedJourney";

const Weather = () => {

    const [weather, setWeather] = useState();

    useEffect(() => {
        const getWeather = async () => {
            let response = await axios.get('http://localhost:8082/weather/timeline', {params: {location: 'London', startdate: '2022-12-05', enddate: '2022-12-12'}});
            let weatherdata = await response.data;
            setWeather(weatherdata);
        };
       getWeather();
    }, []);
    return (
        <p>{weather}</p>
    )
 
    
}

export default Weather;