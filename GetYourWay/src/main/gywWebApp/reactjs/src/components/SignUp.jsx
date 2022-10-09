import React from "react";
import SignUpForm from "./SignUpForm";
import {Col, Container, Row} from "react-bootstrap";
import {NavLink} from "react-router-dom";

const SignUp = () => {
    return (
        <Container className={"mx-5"}>
            <Row>
                <h3 className={"mb-3"}>Sign Up</h3>
            </Row>
            <Row >
                <Col md={6}>
                    <SignUpForm/>
                    <p>Already have an account? <NavLink to={"/login"} >Log in here</NavLink></p>
                </Col>
                <Col>
                    <div className={"border rounded-3 p-3 mb-3 bg-light d-flex flex-row"}>
                        <div className={"mx-3"}>
                            <h3 className={"h1 display-3"}>£10</h3>
                        </div>
                        <div>
                            <p>Sign up to Get Your Way for only £10.</p>
                            <p>Get Your Way brings together travel and weather information from around the web, building your perfectly tailored travel experience</p>
                            <p>Subscribe now and discover travel destinations based on your favourite Sky shows</p>
                        </div>
                        </div>
                    <div className={"rounded-3 overflow-hidden"}>
                        <img className="smallimg" src={"images/8dest.jpeg"} style={{objectFit: "cover", width:"100%", maxHeight:250}}/>
                    </div>
                </Col>
            </Row>
        </Container>

    )
};
/*
<Col>
                    <img className="smallimg" src={"images/8dest.jpeg"} style={{objectFit: "cover", width:"100%", height: "100%"}}/>
                </Col>
 */
export default SignUp;