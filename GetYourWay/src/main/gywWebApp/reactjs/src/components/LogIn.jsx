import React, {useEffect, useState} from 'react';
import axios from "axios";
import { useNavigate } from "react-router-dom";
import {Button, Form, Container, Row, Col} from "react-bootstrap";

const LogIn = ({setAuthenticated}) => {
    console.log(process.env.REACT_APP_SPRING_ROOT)
    const [emailAddress, setEmailAddress] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');


    let navigate = useNavigate();

    useEffect(() =>{
        console.log(localStorage.getItem("logged_in_as"));
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
                navigate("/");
            }
        ).catch(error => console.log(error));
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
                                          type="text"
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
                            <Form.Text className={"text-danger"}>{error}</Form.Text>
                        </Form.Group>
                        <Form.Group className={"mb-3"}>
                            <Button type="submit">Submit</Button>
                        </Form.Group>
                    </Form>
                </Col>
                <Col md={6}>
                    <img className="smallimg" src={"images/8dest.jpeg"} style={{objectFit: "cover", width:"100%", height: "100%"}}/>
                </Col>
            </Row>

        </Container>
    );
}

export default LogIn;
