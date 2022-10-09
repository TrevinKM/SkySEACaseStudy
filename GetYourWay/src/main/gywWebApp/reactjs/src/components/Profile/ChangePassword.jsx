import React from 'react';
import {useState, useEffect} from "react";

import {Col, Container, Row, Form, Button} from "react-bootstrap";
import axios from "axios";
const ChangePassword = () => {
    const [selected, setSelected] = useState(false);
    const [newPassword, setNewPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    const [error, setError] = useState('');
    const [success, setSuccess] = useState(false);

    const savePassword =()=> {
        axios.patch(`${process.env.REACT_APP_SPRING_ROOT}/updatepassword/${localStorage.getItem("logged_in_as")}`, {password: newPassword})
            .then(()=>{
                setSelected(false);
                setSuccess(true);
                setError('');
            }
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
                        {error.length > 0 ? <p className={"text-danger"}>{error}</p> : <></>}
                        {success? <p className={"text-success fw-bold"}>Password saved!</p> : <></>}
                        <Col md={12} className={'d-flex flex-row'}>
                            {selected ?
                                <Button variant="secondary"  onClick={() => {setSelected(false); setNewPassword('');setConfirmPassword('')}} >Cancel
                                </Button>
                                : <></>
                            }
                            <Button className={selected? "mx-3" : "m-0"} variant={!selected ? "danger" : "warning"} onClick={() => selected ? submitPassword() : setSelected(true)} >{!selected ? "Change Password" : "Confirm"}</Button>
                        </Col>

                    </Row>
                </Container>
            </Form>
        </>
    )
}
export default ChangePassword;
