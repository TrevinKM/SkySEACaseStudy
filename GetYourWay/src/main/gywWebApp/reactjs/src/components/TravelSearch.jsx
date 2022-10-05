import React, { useState } from 'react';
import Weather from './Weather';
import Locate from "./Locate";

const TravelSearch = () => {
    const [origin, setOrigin] = useState();
    const [destination, setDestination] = useState();
    return (
        <>
            <p>Flights API</p>
            <Weather />
            <Locate handleChoice={setDestination} display={"Origin"}/>
            <Locate handleChoice={setOrigin} display={"Destination"}/>

        </>
    )
};

export default TravelSearch;