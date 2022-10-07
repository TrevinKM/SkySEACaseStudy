import React, { useState } from 'react';
import SearchBar from "./SearchBar";

const TravelSearch = () => {
    const [origin, setOrigin] = useState();
    const [destination, setDestination] = useState();
    return (
        <>
            <div>
                <p>
                    <h1>Find Your Way</h1>
                </p>
                <p>
                    Search for a destination or use your location and desired destination to begin your adventure.
                </p>
                <p>
                    <SearchBar />
                </p>
            </div>
        </>
    )
};

export default TravelSearch;