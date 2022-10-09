import React, { useState } from 'react';
import SearchBar from "./SearchBar";
import {Container, Image, Card, Row, CardGroup} from "react-bootstrap";


const TravelSearch = () => {
    const [origin, setOrigin] = useState();
    const [destination, setDestination] = useState();
    return (
        <>
            
                
                {/*<Card>*/}
                {/*<h2>Find Your Way</h2>*/}
                {/*<p>*/}
                {/*    Search for a destination to begin your adventure.*/}
                {/*</p>*/}
                {/*</Card>*/}
                <CardGroup>
                <Card>
                <center>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <h2>Find Your Way</h2>
                    <p>
                        Search for a destination to begin your adventure.
                    </p>
                </center>
                    <SearchBar />
                
                </Card>
               
               
            
                <Card>
                
                <Image
                    src="/images/7dest.jpeg"
                    style={{width: '100%'}}
                    className="align-content-center"
                
                />
                </Card>
                </CardGroup>
            
           
           
        </>
    )
};

export default TravelSearch;