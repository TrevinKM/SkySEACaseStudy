import React, { useState } from 'react';
import Locate from './Locate';

const TravelSearch = () => {
    const [origin, setOrigin] = useState();
    const [destination, setDestination] = useState();
    return (
        <>
            <p>Flights API</p>
            <Locate handleChoice={setDestination} display={"Origin"}/>
            <Locate handleChoice={setOrigin} display={"Destination"}/>
            <p></p>
            <p>Weather API</p>
            <p>Journey Details</p>
        </>
    )
};

export default TravelSearch;