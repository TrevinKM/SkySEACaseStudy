import React from "react";
import axios from "axios";
import { useEffect } from "react";
import { useState } from "react";
import WeatherDay from "./WeatherDay";

const Weather = () => {

    const [weather, setWeather] = useState([]);

    useEffect(() => {
        const getWeather = async () => {
            let response = await axios.get('http://18.169.58.161:8082/weather/timeline', {params: {location: 'London', startdate: '2022-12-05', enddate: '2022-12-12'}});
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