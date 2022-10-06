import React, { useState } from 'react';
import Weather from './Weather';
import Locate from "./Locate";
import SearchBar from "./SearchBar";

const TravelSearch = () => {
    const [origin, setOrigin] = useState();
    const [destination, setDestination] = useState();
    return (
        <>
            <p>Flights API</p>
            <SearchBar />

            <Locate handleChoice={setDestination} display={"Your location"}/>
            <Locate handleChoice={setOrigin} display={"Destination"}/>
            <Weather />
            <p></p>
        </>
    )
};

export default TravelSearch;