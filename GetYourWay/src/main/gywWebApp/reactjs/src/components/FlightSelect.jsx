import React from "react";
import Weather from "./Weather";
import {Card, CardGroup} from "react-bootstrap";

function FlightSelect(props) {
    const providers = ["Which", "TUI", "TravelSupermarket", "Kayak", "SkyScanner", "Which"]
    const options = props.flightOptions.map((flight, index) =>
        <>
            <input type="checkbox" id={flight.id} name="select" value={index} />
            <label htmlFor={flight.id}>
                {"Cheapest price: " + flight.price.grandTotal + " " + flight.price.currency}
            </label>
            <div>
                Flight-Codes: {providers[parseInt(flight.id)] + " [ " + flight.itineraries[1].duration + " ] "}
            </div>
            <div>
                Journey Type: {flight.oneWay ? "This is a single journey" : "This is a return trip"}
            </div><br></br>
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