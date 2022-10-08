import React from 'react';
import {useState} from "react";
import axios from "axios";
import {Col, Row, Form, Button} from "react-bootstrap";
const EditProfile = ({user, setUser, loading}) => {
    const [disabled, setDisabled ] = useState(true);
    const [error, setError ] = useState('');

    const submitForm = () => {
        console.log(user);
        axios.patch(`${process.env.REACT_APP_SPRING_ROOT}/user/user/22`, user)
            .then(()=>setDisabled(!disabled)).catch((err) => console.log(err))
            .catch(()=> setError('Something went wrong! Please check your details and try again later'))
    }


    return (
        <>
            <h4>Your details</h4>
            {loading ? <></> :
                <>
                <Form>
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>Email Address</Form.Label>
                        <Form.Control type="text" placeholder="Enter email" value={user.emailAddress}
                                      onChange={(e) => setUser({...user, emailAddress: e.target.value})}
                                      disabled={disabled}/>
                    </Form.Group>
                    <Row>
                        <Col>
                            <Form.Group className="mb-3" controlId="formBasicEmail">
                                <Form.Label>First Name</Form.Label>
                                <Form.Control type="text" placeholder="Enter email" value={user.firstName}
                                              onChange={(e) => setUser({...user, firstName: e.target.value})}
                                              disabled={disabled}/>
                            </Form.Group>
                        </Col>
                        <Col>
                            <Form.Group className="mb-3" controlId="formBasicEmail">
                                <Form.Label>Last Name</Form.Label>
                                <Form.Control type="text" placeholder="Enter email" value={user.lastName}
                                              onChange={(e) => setUser({...user, lastName: e.target.value})}
                                              disabled={disabled}/>
                            </Form.Group>
                        </Col>
                    </Row>
                </Form>
                <p className={"text-danger"}>{error}</p>
                <Button onClick={()=>disabled ? setDisabled(false) : submitForm()}>{disabled ? "Edit Profile" : "Save"}</Button>
                    </>
                    }
        </>
    )
}
export default EditProfile;
