import React from "react";
import Weather from "./Weather";
import {Card, CardGroup} from "react-bootstrap";

function FlightSelect(props) {
    const providers = ["Which", "TUI", "TravelSupermarket", "Kayak", "SkyScanner", "Which"]
    const options = props.flightOptions.map((flight, index) =>
        <>
            <Card>
            <a href={"http://" + providers[parseInt(flight.id)] + ".com"}><Card.Img variant="top" className="smallimg" src={"images/" + providers[parseInt(flight.id)] + ".jpeg"} alt= {"Logo"} /></a>
            Travel Time: {flight.itineraries[1].duration.slice(2)}<br/>
            {"Best price: " + flight.price.grandTotal + " " + flight.price.currency + " "} {flight.oneWay ? "one way" : "return"}
            </Card>
        </>
    );

    return (
        <div>
            {props.flightOptions.length > 0 &&
                <form onChange={(e) => props.setFlight(props.flightOptions[e.target.value])}>
                    {options}
                </form>
            }
            <CardGroup>
            {
                props.returningDate&&
                props.departureDate&&
                props.destination&&
                <Card>
                <Weather startDate={props.departureDate} endDate={props.returningDate} endLocation={props.destination} />
                </Card>

            }
            </CardGroup>
        </div>
    );
}

export default FlightSelect;