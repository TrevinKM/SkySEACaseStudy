import React from 'react';
import {useState, useEffect} from "react";

import {Col, Container, Row, Form, Button} from "react-bootstrap";
const ChangePassword = () => {
    const [selected, setSelected] = useState(false);
    const [newPassword, setNewPassword] = useState(true);
    return (
        <>
            <h4 className={"mb-3"}>Change Password</h4>
            <Form className={"mb-3"}>
                <Form.Group className="mb-3" controlId="formBasicEmail">
                    <Form.Control type="text" placeholder="Enter password"/>
                </Form.Group>
                <Form.Group className="mb-3" controlId="formBasicEmail">
                    <Form.Control type="text" placeholder="Confirm password" />
                </Form.Group>
                <Container>
                    <Row>
                        <Col>
                            {selected ?
                                <Button variant="secondary" className={"mr-3"} onClick={() => setSelected(!selected)} >Cancel
                                </Button>
                                : <></>
                            }
                            <Button variant={!selected ? "danger" : "warning"} onClick={() => setSelected(!selected)} >{!selected ? "Change Password" : "Confirm"}</Button>
                        </Col>

                    </Row>
                </Container>

            </Form>
        </>
    )
}
export default ChangePassword;
