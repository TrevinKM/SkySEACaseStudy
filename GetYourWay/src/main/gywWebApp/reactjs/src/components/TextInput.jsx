import React from "react";
import Button from "react-bootstrap/Button";
import {Col, Container, Row} from "react-bootstrap";

const TextInput = props => (

    <div className="d-flex justify-content-center">
            <form onSubmit={props.onSubmit}>
                <label>{props.display} </label>
                <input className="form-control" value={props.value} onChange={props.onChange} placeholder={'Enter a location...'}></input>
                <br/>
                <center>
                <Button variant="outline-secondary" type="submit" className="btn" value="Enter">Enter</Button>
                </center>
            </form>
    </div>

);

export default TextInput;