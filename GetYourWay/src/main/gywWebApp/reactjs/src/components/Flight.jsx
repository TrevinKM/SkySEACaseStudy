import React, { useState } from "react";
import FlightSelect from "./FlightSelect";
import axios from "axios";

function Flight(props) {
    const [passengers, setPassengers] = useState("1");
    const [departureDate, setDepartDate] = useState('');
    const [returningDate, setReturnDate] = useState('');
    const [flightOptions, setFlightOptions] = useState([]);

    async function submit(e, props){
        e.preventDefault();
        //
        // fetch(
        //     "/api/flights/?origin=" + props.origin  +
        //     "&destination=" + props.destination +
        //     "&departDate=" + departDate +
        //     "&adults=" + passengers +
        //     returnDateParam
        // )
        //     .then((response) => response.json())
        //     .then((json) => {
        //         setFlightOptions(json);
        //     });
        if(returningDate){
            await axios.get('http://localhost:8082/api/flights/', {params: {origin: props.origin, destination: props.destination, departDate: departureDate, adults: passengers, returnDate: returningDate}})
                .then((res) => {setFlightOptions(res.data);
                    console.log(res.data)});
        }else {
            await axios.get('http://localhost:8082/api/flights/', {params: {origin: props.origin, destination: props.destination, departDate: departureDate, adults: passengers}})
                .then((res) => {setFlightOptions(res.data);
                    console.log(res.data)});
        }


    }

    return (
        <div>
            <form onSubmit={(e) => submit(e, props)}>
                <label htmlFor="passengers">Passengers:</label>
                <input onChange={(e) => setPassengers(e.target.value)}
                       type="number"
                       name="passengers"
                       min="1"
                       max="5"
                       required /><br></br>
                <label htmlFor="departure">Depart Date:</label>
                <input type="date"
                       onChange={(e) => setDepartDate(e.target.value)}
                       id="departure"
                       name="departure"
                       required /><br></br>
                <label htmlFor="return">Return Date:</label>
                <input type="date"
                       onChange={(e) => setReturnDate(e.target.value)}
                       id="return"
                       name="return" /><br></br>
                <input type="submit" />
            </form>
            <FlightSelect flightOptions={flightOptions} setFlight={props.setFlight} />
        </div>
    );
};

export default Flight;