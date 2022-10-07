import React from "react";

function FlightSelect(props) {
    const providers = ["Which", "TUI", "TravelSupermarket", "Kayak", "SkyScanner"]
    const options = props.flightOptions.map((flight, index) =>
        <>
            <input type="radio" id={flight.price.currency} name="select" value={index} />
            <label htmlFor={flight.id}>
                {"Price: " + flight.price.grandTotal + " " + flight.price.currency}
            </label>
            <div>
                Flight-Codes: {providers[parseInt(flight.id)] + " [ " + flight.itineraries[1].duration + " ] "}
            </div>
            <div>
                Available Seats: {flight.numberOfBookableSeats}
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

        </div>
    );
}

export default FlightSelect;