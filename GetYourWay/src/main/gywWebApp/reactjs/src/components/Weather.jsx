import React from "react";
import axios from "axios";
import { useEffect } from "react";
import { useState } from "react";
import WeatherDay from "./WeatherDay";
import Card from 'react-bootstrap/Card';
import ListGroup from 'react-bootstrap/ListGroup';
import { CardGroup } from "react-bootstrap";

const Weather = (props) => {
    console.log(props.endDate);
    console.log(props.endLocation);
    const [weather, setWeather] = useState([]);

    useEffect(() => {
        const getWeather = async () => {

            let response = await axios.get('http://localhost:8082/weather/timeline', {params: {location: props.endLocation, startdate: props.startDate, enddate: props.endDate}});
            console.log('http://localhost:8082/weather/timeline', {params: {location: props.endLocation, startdate: props.startDate, enddate: props.endDate}});
            let weatherdata = await response.data;
            setWeather(weatherdata);
        };
            getWeather();
    }, []);

    
    const str = props.startDate;
    const startDat = new Date(str);
    const str2 = props.endDate;
    const endDat = new Date(str2);
    
    return (
        <>
            <Card >
            <Card.Img variant="top" src={"images/forecast.jpeg"} alt= {"Picture of weather forecast icons"}/>
            <Card.Header>Weather Forecast for {props.endLocation} from {startDat.toLocaleDateString()} to {endDat.toLocaleDateString()} </Card.Header>
            <ListGroup variant="flush">
                    {weather.map((data, key) => {
                        const weatherDate = (startDat, key) => {
                            let result = new Date(startDat);
                            result.setDate(result.getDate() + key);
                            return result.toLocaleDateString();
                        }                        
                        return (
                            <>
                            <ListGroup.Item>
                                <h6>{weatherDate(startDat, key)}</h6>
                                <WeatherDay temp={data.temp} humidity={data.humidity} precip={data.precip}/>
                            </ListGroup.Item>
                            </> 
                        )
                    }
                    )
                }
            </ListGroup>
        </Card>
        </>
    );
}


export default Weather;