import React, {useEffect, useState} from 'react';
import axios from "axios";
import {NavLink, useNavigate} from "react-router-dom";
import {Button, Form, Container, Row, Col} from "react-bootstrap";

const LogIn = ({setAuthenticated}) => {
    const [emailAddress, setEmailAddress] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    let navigate = useNavigate();

    useEffect(() =>{
        if(localStorage.getItem("logged_in_as") != null){
            setAuthenticated(1);
        } else{
            setAuthenticated(0);
        }
    }, []);

    const submitForm = async event => {
        event.preventDefault();
        axios.post(`${process.env.REACT_APP_SPRING_ROOT}/userLogin`, {
            email: emailAddress,
            password: password
        }).then(response => {
                localStorage.removeItem("logged_in_as");
                localStorage.setItem("logged_in_as", response.data);
                setAuthenticated(1);
                navigate("/travelSearch");
            }
        ).catch(error => {
            setError("We were unable to log you in. Are your details correct?")
        });
    }

    return (
        <Container>
            <Row>
                <Col md={6}>
                    <h3>Log In</h3>

                    <Form onSubmit={submitForm}>
                        <Form.Group className={"mb-3"}>
                            <Form.Label>Email Address:</Form.Label>
                            <Form.Control name="email"
                                          type="email"
                                          value={emailAddress}
                                          onChange={e => setEmailAddress(e.target.value)} />
                        </Form.Group>
                        <Form.Group className={"mb-3"}>
                            <Form.Label>Password: </Form.Label>
                            <Form.Control type="password"
                                          name="password"
                                          value={password}
                                          onChange={e => setPassword(e.target.value)} />
                        </Form.Group>
                        <Form.Group>
                            <p className={"text-danger"}>{error}</p>
                        </Form.Group>
                        <Form.Group className={"mb-3"}>
                            <Button type="submit">Log In</Button>
                        </Form.Group>
                    </Form>
                    <p>Don't have an account? <NavLink to={"/signup"} >Sign up here</NavLink></p>
                </Col>
                <Col md={6} >
                    <div className={"rounded-3 overflow-hidden"}>
                        <img className="smallimg" src={"images/8dest.jpeg"} style={{objectFit: "cover", width:"100%", height: "100%"}}/>

                    </div>
                </Col>
            </Row>
            <Row>
            </Row>
        </Container>
    );
}

export default LogIn;
