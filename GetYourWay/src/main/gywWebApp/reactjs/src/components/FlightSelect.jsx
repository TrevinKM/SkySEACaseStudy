import React from "react";
import Weather from "./Weather";
import {Card, CardGroup} from "react-bootstrap";

function FlightSelect(props) {
    const providers = ["Which", "TUI", "TravelSupermarket", "Kayak", "SkyScanner", "Which"]
    const options = props.flightOptions.map((flight, index) =>
        <>
            <Card className={"p-3 m-3"}>
            <a target="_blank" href={"http://" + providers[parseInt(flight.id)] + ".com"}><Card.Img variant="top" className="smallimg" src={"images/" + providers[parseInt(flight.id)] + ".jpeg"} alt= {"Logo"} /></a>
            Travel Time: {flight.itineraries[1].duration.slice(2).toLowerCase()}<br/>
            {"Best price: " + flight.price.grandTotal + " " + flight.price.currency + " | "} {flight.oneWay ? "One Way" : "Return"}
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
        </div>
    );
}

export default FlightSelect;