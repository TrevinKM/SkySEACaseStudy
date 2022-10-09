import React, { useState } from "react";
import axios from "axios";
import Button from "react-bootstrap/Button";
import {ClipLoader} from "react-spinners";
const Flight = (props) => {
    const override = {
        display: "block",
        margin: "0 auto",
    };

    async function submit(e, props){
        e.preventDefault();
        props.setLoading(true);
        if(props.returningDate){
            await axios.get(`${process.env.REACT_APP_SPRING_ROOT}/api/flights/`, {params: {origin: props.origin, destination: props.destination, departDate: props.departureDate, adults: props.passengers, returnDate: props.returningDate}})
                .then((res) => {props.setFlightOptions(res.data);
                    props.setLoading(false)
                    console.log(res.data)}).catch(() => props.setLoading(false));

        }else {
            await axios.get(`${process.env.REACT_APP_SPRING_ROOT}/api/flights/`, {params: {origin: props.origin, destination: props.destination, departDate: props.departureDate, adults: props.passengers}})
                .then((res) => {props.setFlightOptions(res.data); props.setLoading(false);
                    console.log(res.data)}).catch(()=>props.setLoading(false));

        }
    }
    return (
        <div>
            <form onSubmit={(e) => submit(e, props)}>
                <label htmlFor="passengers">Passengers:</label>
                <input onChange={(e) => props.setPassengers(e.target.value)}
                       type="number"
                       name="passengers"
                       min="1"
                       max="5"
                       required /><br></br><br/>
                <label htmlFor="departure">Depart Date:</label>
                <input type="date"
                       onChange={(e) => props.setDepartDate(e.target.value)}
                       id="departure"
                       name="departure"
                       required /><br></br><br/>
                <label htmlFor="return">Return Date:</label>
                <input type="date"
                       onChange={(e) => {props.setReturnDate(e.target.value);
                           props.setFlightDestination(props.destination)}}
                       id="return"
                       name="return" /><br></br><br/>
                <Button variant="outline-secondary" type="submit" className="btn-sm" value="Enter">Submit</Button><br/><br/>
            </form>
            {props.loading ? <ClipLoader
                    color={'#34e1eb'}
                    loading={props.loading}
                    size={50}
                    cssOverride={override}
                    aria-label="Loading Spinner"
                    data-testid="loader"
                /> :
               <></>
            }
        </div>
    );
}

export default Flight;