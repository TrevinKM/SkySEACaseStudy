import React, { useState } from 'react';
import axios from "axios";
import {Button, Form} from "react-bootstrap";
const SignUpForm = props => {

    const [error, setError] = useState(``);

    const [firstName, setFirstName] = useState(``);
    const [lastName, setLastName] = useState(``);
    const [userEmailAddress, setUserEmailAddress] = useState(``);
    const [userPassword, setUserPassword] = useState(``);
    const [confirmPassword, setConfirmPassword] = useState(``);
    const [userid, setuserid] = useState("");

    const formValid =    () =>{
        if(firstName.length < 2) { setError("First name must exist"); return false;}
        if(lastName.length < 2) { setError("Last name must exist"); return false;}
        if(userEmailAddress.length < 2) { setError("Email must exist"); return false;}
        if(userPassword.length < 6) { setError("Passwords must be at least 6 characters"); return false;}
        if(confirmPassword != userPassword) { setError("The passwords provided don't match"); return false;}

        return true;
    }

    const createSubscription = async event => {
        event.preventDefault();
        console.log(userEmailAddress)
        axios.post(`${process.env.REACT_APP_SPRING_ROOT}/subscription/subscribe`,{"body": {}},
            {
            withCredentials: false,
            headers:{'userId':userid}
            }
        ).then(response => window.location.href = response.data).catch(err => console.log(err))
    }

    const submitForm = async event => {
        axios.post(`${process.env.REACT_APP_SPRING_ROOT}/process_register`, {
            firstName: firstName,
            lastName: lastName,
            emailAddress: userEmailAddress,
            password: userPassword,
            role: "USER",
            enabled: true
        }).then(result => {setuserid(result.data); setError('')})
            .catch(err => setError(err.response.data.toString()));

    }

    return (
        <>
        <Form >
            <Form.Group>
                <Form.Label htmlFor="firstName">First Name: &nbsp;</Form.Label>
                <Form.Control
                    type="text"
                    name="firstName"
                    placeholder="Enter your first name"
                    value={firstName}
                    onChange={event => setFirstName(event.target.value)}
                />
            </Form.Group>

            <Form.Group className="mb-3">
                <Form.Label htmlFor="lastName">Last Name: &nbsp;</Form.Label>
                <Form.Control
                    type="text"
                    name="lastName"
                    placeholder="Enter your last name"
                    value={lastName}
                    onChange={event => setLastName(event.target.value)}
                />
            </Form.Group>

            <Form.Group className="mb-3">
                <Form.Label htmlFor="emailAddress">Email Address: &nbsp;</Form.Label>
                <Form.Control
                    type="text"
                    name="emailAddress"
                    placeholder="Enter your email address"
                    value={userEmailAddress}
                    onChange={event => setUserEmailAddress(event.target.value)}
                />
            </Form.Group>

            <Form.Group className="mb-3">
                <Form.Label htmlFor="password">Password: &nbsp;</Form.Label>
                <Form.Control
                    type="password"
                    name="password"
                    placeholder="Password needs to be at least 8 characters"
                    value={userPassword}
                    onChange={event => setUserPassword(event.target.value)}
                />
            </Form.Group>

            <Form.Group className="mb-3">
                <Form.Label htmlFor="setConfirmPassword">Confirm Password: &nbsp;</Form.Label>
                <Form.Control
                    type="password"
                    name="confirmPassword"
                    placeholder="Confirm your chosen password"
                    value={confirmPassword}
                    onChange={event => setConfirmPassword(event.target.value)}
                />
            </Form.Group>
            <Form.Group>
                <p className={"text-danger"}>{error}</p>
            </Form.Group>
            <Form.Group className="mb-3">
                <Button variant={userid != 0 ? "secondary": "primary"} onClick={()=> { if(formValid()) submitForm()}} className={"w-100"} disabled={userid !=0}>Sign Up</Button>
            </Form.Group>
        </Form>
            {userid != 0 ? <Button variant="primary" onClick={createSubscription} className={"w-100 shadow"}>Checkout</Button> : <></>}

    </>
    );
};

//SignUpForm.propTypes = {
//    submitForm: PropTypes.func.isRequired}

export default SignUpForm;