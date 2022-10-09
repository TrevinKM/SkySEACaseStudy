import React from "react";
import axios from "axios";
import { useEffect } from "react";
import { useState } from "react";
import WeatherDay from "./WeatherDay";
import Card from 'react-bootstrap/Card';
import ListGroup from 'react-bootstrap/ListGroup';
import {ClipLoader} from "react-spinners";

const Weather = (props) => {
    const [weather, setWeather] = useState([]);
    const [loading, setLoading] = useState(false);

    const override = {
        display: "block",
        margin: "0 auto",
    };

    useEffect(() => {
        setLoading(true);
        const getWeather = async () => {
            let response = await axios.get(`${process.env.REACT_APP_SPRING_ROOT}/weather/timeline`, {params: {location: props.endLocation, startdate: props.startDate, enddate: props.endDate}});
            let weatherdata = await response.data;
            setWeather(weatherdata);
            setLoading(false);
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
                {loading ? <ClipLoader
                        color={'#34e1eb'}
                        loading={props.loading}
                        size={50}
                        cssOverride={override}
                        aria-label="Loading Spinner"
                        data-testid="loader"
                    /> :
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
                }
        </Card>
        </>
    );
}


export default Weather;