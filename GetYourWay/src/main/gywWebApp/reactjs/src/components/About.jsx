import React from "react";
import AboutCards from "./AboutCards";
import {Container} from "react-bootstrap";

const About = () => {
    return (
        <Container>
        <h1>About Get Your Way</h1>
            <p>Get Your Way was created by The Increments in October 2022.<br/>
            Below are profile cards of the members of The Increments.
            </p>
            <br/>
        <AboutCards />
        </Container>
    );
}
export default About;