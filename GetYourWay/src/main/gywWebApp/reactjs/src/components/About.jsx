import React from "react";
import AboutCards from "./AboutCards";
import {Container} from "react-bootstrap";

const About = () => {
    return (
        <Container>
        <h1>About Get Your Way</h1>
            <p>Get Your Way was created by The Increments as the project element of Sky's Graduate Software Engineering Academy Boot Camp in October 2022. The Increments are:
            </p>
            <br/>
        <AboutCards />
        </Container>
    );
}
export default About;
