import React from "react";
import SignUpForm from "./SignUpForm";
import {Col, Container, Row} from "react-bootstrap";
import {NavLink} from "react-router-dom";

const SignUp = () => {
    return (
        <Container className={"mx-5"}>
            <Row >
                <Col md={6}>
                    <h3 className={"mb-3"}>Sign Up</h3>
                    <SignUpForm/>
                    <p>Already have an account? <NavLink to={"/login"} >Log in here</NavLink></p>
                </Col>
                <Col>
                    <img className="smallimg" src={"images/8dest.jpeg"} style={{objectFit: "cover", width:"100%", height: "100%"}}/>
                </Col>
            </Row>
        </Container>

    )
};
export default SignUp;