import React, { useState, useEffect } from 'react';
import Weather from './Weather';
import Locate from "./Locate";
import SearchBar from "./SearchBar";
import {useLocation, useNavigate} from "react-router-dom";
import Flight from "./Flight";
import MapsAPITest from "./MapsAPITest";
import {Card, CardGroup} from "react-bootstrap";

const TravelInfo = () => {
    const location = useLocation();
    const [origin, setOrigin] = useState();
    const [destination, setDestination] = useState(location.state.destination);
    const [flight, setFlight] = useState();
    const [thisLocation, setThisLocation] = useState();
    // useEffect(() => {
    //     // Update the document title using the browser API
    //     setDestination(location.state.destination)
    // },  [location.state.destination]);

    return (
        
        <>
            <h1 style={{paddingTop: '15px', paddingBottom: '15px'}}></h1>
            <CardGroup>
                <Card>
                    <Locate handleChoice={setDestination} display={<strong>Your Location</strong>}/>
                </Card>
                <Card>
                    <Locate value = {location.state.destination} handleChoice={setOrigin} display={<strong>Your Destination</strong>}/>
                </Card>
                <Card>
                        { origin &&
                            destination &&
                            <MapsAPITest origin={origin} destination={destination} />
                        }
                </Card>
                <Card>
                    <center>
                        { origin &&
                            destination &&
                            <Flight origin={origin} destination={destination} setFlight={setFlight} endDestination={location.state.destination} />
                        }
                    </center>
                </Card>
            </CardGroup>

            <h1 style={{paddingTop: '15px', paddingBottom: '15px'}}></h1>

        </>
    )

};

export default TravelInfo;