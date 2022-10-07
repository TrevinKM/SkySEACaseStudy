import React from "react";
import axios from "axios";
import { useEffect } from "react";
import { useState } from "react";
import WeatherDay from "./WeatherDay";

const Weather = (props) => {
    console.log(props.endDate);
    console.log(props.endLocation);
    const [weather, setWeather] = useState([]);

    useEffect(() => {
        const getWeather = async () => {

            let response = await axios.get('http://localhost:8082/weather/timeline', {params: {location: props.endLocation, startdate: props.startDate, enddate: props.endDate}});
            let weatherdata = await response.data;
            setWeather(weatherdata);
        };
        getWeather();
    }, []);
    return (
        <table>

            {weather.map((data, key) => {
                return (
                    <WeatherDay temp={data.temp} humidity={data.humidity} precip={data.precip}/>
                )
            }
            )
            }
        </table>
    )
}

export default Weather;