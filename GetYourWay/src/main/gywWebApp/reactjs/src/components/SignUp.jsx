import React from "react";
import SignUpForm from "./SignUpForm";
import {Col, Container, Row} from "react-bootstrap";

const SignUp = () => {
    return (
        <Container className={"mx-5"}>
            <Row>
            </Row>
            <Row >
                <Col md={6}>
                    <h3 className={"mb-3"}>Sign up</h3>
                    <SignUpForm/>
                </Col>
                <Col>
                    <img className="smallimg" src={"images/8dest.jpeg"} style={{objectFit: "cover", width:"100%", height: "100%"}}/>
                </Col>
            </Row>
        </Container>

    )
};
export default SignUp;