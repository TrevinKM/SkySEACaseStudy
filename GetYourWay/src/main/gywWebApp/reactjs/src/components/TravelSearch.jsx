import React, { useState } from 'react';
import SearchBar from "./SearchBar";
import {Container, Image} from "react-bootstrap";

const TravelSearch = () => {
    const [origin, setOrigin] = useState();
    const [destination, setDestination] = useState();
    return (
        <>
            <Container>

                <h2>Find Your Way</h2>
                <p>
                    Search for a destination or use your location and desired destination to begin your adventure.
                </p>
                <p>
                    <SearchBar />
                </p>

                <div className="text-center justify-content-md-center">
                <Image
                    src="/images/7dest.jpeg"
                    style={{width: '70%'}}
                    className="align-content-center"
                />
            </div>
            </Container>
        </>
    )
};

export default TravelSearch;