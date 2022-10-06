import React, { useState } from 'react';
// import PropTypes from 'prop-types';
import axios from "axios";
import {useNavigate} from "react-router-dom";
import {Button, Form} from "react-bootstrap";
const SignUpForm = props => {

    const usersUrl = 'http://localhost:3000/users';

    const [firstName, setFirstName] = useState(``);
    const [lastName, setLastName] = useState(``);
    const [userEmailAddress, setUserEmailAddress] = useState(``);
    const [userPassword, setUserPassword] = useState(``);
    const [confirmPassword, setConfirmPassword] = useState(``);

    const [userid, setuserid] = useState("");

    const createSubscription = async event => {
        event.preventDefault();
        console.log(userEmailAddress)
        axios.post('http://18.169.58.161:8082/subscription/subscribe',{"body": {}},
            {
            withCredentials: false,
            headers:{'userId':userid}
            }
        ).then(response => window.location.href = response.data).catch(err => console.log(err))
    }

    const submitForm = async event => {
        event.preventDefault();
        console.log(userEmailAddress)
        axios.post('http://18.169.58.161:8082/process_register',{
            firstName: firstName,
            lastName: lastName,
            emailAddress: userEmailAddress,
            password: userPassword,
            role: "USER",
            enabled:true
        }).then(result => setuserid(result.data)).catch(err => console.log(err))
    }

    return (
        <>
        <Form onSubmit={submitForm} >
            <Form.Group>
                <Form.Label htmlFor="firstName">First Name: &nbsp;</Form.Label>
                <Form.Control
                    type="email"
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
            <Form.Group className="mb-3">
                <Form.Control type="submit" className="btn" value="Sign Up"  />
            </Form.Group>
        </Form>
            {userid != 0 ? <Button onClick={createSubscription}>Checkout</Button> : <></>}

    </>
    );
};

//SignUpForm.propTypes = {
//    submitForm: PropTypes.func.isRequired}

export default SignUpForm;