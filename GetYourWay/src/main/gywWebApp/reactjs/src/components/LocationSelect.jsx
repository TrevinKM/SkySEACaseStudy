import React from "react";
import {Card, Col, Container, Row} from "react-bootstrap";
function LocationSelect(props) {
    const options = props.data.map((location) =>
            <React.Fragment key={location.iataCode}>
            <input type="checkbox" id={location.iataCode} name="select" value={location.iataCode} />
            <label style={{paddingTop: '2.5px', paddingBottom: '2.5px'}} htmlFor={location.iataCode}>
                {location.name + ": " + location.iataCode}
            </label><br></br>
            </React.Fragment>
    );
    return (
        <div>
            <h6>Airports close to your chosen location</h6>
            {props.data.length > 0 &&
                <form onChange={(e) => props.handleChoice(e.target.value)}>
                    {options}
                </form>
            }
        </div>
    );
}
export default LocationSelect;