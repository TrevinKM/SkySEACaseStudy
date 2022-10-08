import React from "react";
import axios from "axios";
import { useEffect } from "react";
import { useState } from "react";
import WeatherDay from "./WeatherDay";
import Card from 'react-bootstrap/Card';
import ListGroup from 'react-bootstrap/ListGroup';

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

    console.log(typeof(props.startDate));
    return (
        <>
        <Card style={{ width: '18rem' }}>
            <Card.Header>Weather Forecast for {props.endLocation} from {props.startDate} to {props.endDate} </Card.Header>
            <ListGroup variant="flush">
                    {weather.map((data, key) => {
                        console.log("day number" + key)
                        return (
                            <>
                            <ListGroup.Item>
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