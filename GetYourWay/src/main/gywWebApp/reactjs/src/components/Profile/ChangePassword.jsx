import React from 'react';
import {useState, useEffect} from "react";

import {Col, Container, Row, Form, Button} from "react-bootstrap";
import axios from "axios";
const ChangePassword = () => {
    const [selected, setSelected] = useState(false);
    const [newPassword, setNewPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    const [error, setError] = useState('');

    const savePassword =()=> {
        axios.patch(`${process.env.REACT_APP_SPRING_ROOT}/updatepassword/${localStorage.getItem("logged_in_as")}`, {password: newPassword})
            .then(()=>
                setSelected(false)
            ).catch(error => setError('We were unable to update your password. Please try again later!'))
    }

    const submitPassword = () =>{
        if(!selected) return
        if(newPassword != confirmPassword){
            setError("Your passwords don't match!");
            return
        }
        if(newPassword.length < 6) {
            setError("Your password must be at least 6 characters!");
            return
        }
        savePassword()
        setSelected(!selected)

    }

    return (
        <>
            <h4 className={"mb-3"}>Change Password</h4>
            <Form className={"mb-3"}>
                <Form.Group className="mb-3" controlId="formBasicEmail">
                    <Form.Control type="password" placeholder="Enter password" value={newPassword} onChange={(e) => setNewPassword(e.target.value)} />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formBasicEmail">
                    <Form.Control type="password" placeholder="Confirm password" value={confirmPassword} onChange={(e) => setConfirmPassword(e.target.value)} />
                </Form.Group>
                <Container>
                    <Row>
                        <p className={"text-danger"}>{error}</p>
                        <Col>
                            {selected ?
                                <Button variant="secondary" className={"mr-3"} onClick={() => {setSelected(false); setNewPassword('');setConfirmPassword('')}} >Cancel
                                </Button>
                                : <></>
                            }
                            <Button variant={!selected ? "danger" : "warning"} onClick={() => selected ? submitPassword() : setSelected(true)} >{!selected ? "Change Password" : "Confirm"}</Button>
                        </Col>

                    </Row>
                </Container>
            </Form>
        </>
    )
}
export default ChangePassword;
