import React, { useState, useEffect } from 'react';
import Weather from './Weather';
import Locate from "./Locate";
import SearchBar from "./SearchBar";
import {useLocation, useNavigate} from "react-router-dom";
import Flight from "./Flight";

const TravelInfo = () => {
    const location = useLocation();
    const [origin, setOrigin] = useState();
    const [destination, setDestination] = useState(location.state.destination);
    const [flight, setFlight] = useState();
    useEffect(() => {
        // Update the document title using the browser API
        setDestination(location.state.destination)
    },  [location.state.destination]);

    console.log(typeof(location.state.destination))

    return (
        <>
            <Locate handleChoice={setDestination} display={"Your location"}/>
            <Locate value = {location.state.destination} handleChoice={setOrigin} display={"Destination"}/>
            { origin &&
                destination &&
                <Flight origin={origin} destination={destination} setFlight={setFlight}/>
            }
            {/*<Weather />*/}
            <p></p>
        </>
    )

};

export default TravelInfo;