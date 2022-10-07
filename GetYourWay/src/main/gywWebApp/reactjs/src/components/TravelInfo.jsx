import React, { useState } from 'react';
import Weather from './Weather';
import Locate from "./Locate";

const TravelInfo = () => {
    const [origin, setOrigin] = useState();
    const [destination, setDestination] = useState();
    return (
        <>
            <Locate handleChoice={setDestination} display={"Your location"}/>
            <Locate handleChoice={setOrigin} display={"Destination"}/>
            <Weather />
        </>
    )
};

export default TravelInfo;