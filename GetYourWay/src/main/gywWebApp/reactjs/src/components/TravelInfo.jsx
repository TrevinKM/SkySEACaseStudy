import React, { useState, useEffect } from 'react';
import Weather from './Weather';
import Locate from "./Locate";
import SearchBar from "./SearchBar";
import {useLocation, useNavigate} from "react-router-dom";
import Flight from "./Flight";
import MapsAPITest from "./MapsAPITest";
import {Card, Row, CardGroup, Container, Col} from "react-bootstrap";
import FlightSelect from "./FlightSelect";
import CardHeader from "react-bootstrap/CardHeader";

const TravelInfo = () => {
    const location = useLocation();
    const [origin, setOrigin] = useState();
    const [destination, setDestination] = useState(location.state.destination);
    const [flight, setFlight] = useState();
    const [thisLocation, setThisLocation] = useState();


    const [passengers, setPassengers] = useState("1");
    const [departureDate, setDepartDate] = useState('');
    const [returningDate, setReturnDate] = useState('');
    const [flightOptions, setFlightOptions] = useState([]);
    const [flightDestination, setFlightDestination] = useState();
    const [loading, setLoading] = useState(false);


    // useEffect(() => {
    //     // Update the document title using the browser API
    //     setDestination(location.state.destination)
    // },  [location.state.destination]);
    const cardClass = "mx-1 py-3 border rounded bg-light overflow-hidden mb-3"
    return (

        <Container>
            <h3 style={{paddingTop: '15px', paddingBottom: '15px'}}>Your Journey</h3>
            <Row>
                <h4>Search</h4>
            </Row>
            <Row>
            <CardGroup>
                <Card className={cardClass}>
                    <Locate handleChoice={setDestination} display={<strong>Your Location</strong>}/>

                </Card>
                <Card className={cardClass}>
                    <Locate value = {location.state.destination} handleChoice={setOrigin} display={<strong>Your Destination</strong>}/>
                </Card>
                <Card className={cardClass}>
                    <center>
                        { origin &&
                            destination &&
                            <Flight
                                origin={origin}
                                destination={destination}
                                setFlight={setFlight}
                                endDestination={location.state.destination}
                                loading={loading}
                                setLoading={setLoading}
                                returningDate={returningDate}
                                setReturnDate={setReturnDate}
                                passengers={passengers}
                                setFlightOptions={setFlightOptions}
                                setPassengers={setPassengers}
                                setDepartDate={setDepartDate}
                                departureDate={departureDate}
                                setFlightDestination={setFlightDestination}
                            />
                        }
                    </center>
                </Card>
            </CardGroup>
            </Row>
            <Row>
                {origin && destination &&
                    <h4>Results</h4>
                }
            </Row>
            <Row>
                <Col md={7}>
                        { origin &&
                            destination &&
                            <>
                            <Card className={cardClass}>
                                <MapsAPITest origin={origin} destination={destination} />
                            </Card>
                            </>

                        }
                    {flightOptions.length > 0 &&
                        returningDate &&
                        departureDate &&
                        destination &&
                        <Card className={cardClass}>
                            <Weather startDate={departureDate} endDate={returningDate}
                                     endLocation={location.state.destination}/>
                        </Card>
                    }
                </Col>
                <Col md={5}>
                    {flightOptions.length > 0 &&
                        returningDate &&
                        departureDate &&
                        destination &&
                        <Card className={cardClass}>
                            <FlightSelect destination={location.state.destination} departureDate={departureDate}
                                          returningDate={returningDate} flightOptions={flightOptions}
                                          setFlight={setFlight}/>
                        </Card>
                    }
                </Col>
            </Row>
        </Container>
    )

};

export default TravelInfo;

/*

 */