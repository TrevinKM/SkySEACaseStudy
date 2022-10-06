import React, { useState } from 'react';
// import PropTypes from 'prop-types';
import axios from "axios";
import {useNavigate} from "react-router-dom";
import {Button} from "react-bootstrap";
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
        axios.post('http://localhost:8082/subscription/subscribe',{"body": {}},
            {
            withCredentials: false,
            headers:{'userId':userid}
            }
        ).then(response => window.location.href = response.data).catch(err => console.log(err))
    }

    const submitForm = async event => {
        event.preventDefault();
        console.log(userEmailAddress)
        axios.post('http://localhost:8082/process_register',{
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
        <form onSubmit={submitForm} >
            <div className="form-group">
                <label htmlFor="firstName">First Name: &nbsp;</label>
                <input
                    type="text"
                    name="firstName"
                    placeholder="Enter your first name"
                    value={firstName}
                    onChange={event => setFirstName(event.target.value)}
                />
            </div>

            <div className="form-group">
                <label htmlFor="lastName">Last Name: &nbsp;</label>
                <input
                    type="text"
                    name="lastName"
                    placeholder="Enter your last name"
                    value={lastName}
                    onChange={event => setLastName(event.target.value)}
                />
            </div>

            <div className="form-group">
                <label htmlFor="emailAddress">Email Address: &nbsp;</label>
                <input
                    type="text"
                    name="emailAddress"
                    placeholder="Enter your email address"
                    value={userEmailAddress}
                    onChange={event => setUserEmailAddress(event.target.value)}
                />
            </div>

            <div className="form-group">
                <label htmlFor="password">Password: &nbsp;</label>
                <input
                    type="text"
                    name="password"
                    placeholder="Password needs to be at least 8 characters"
                    value={userPassword}
                    onChange={event => setUserPassword(event.target.value)}
                />
            </div>

            <div className="form-group">
                <label htmlFor="setConfirmPassword">Confirm Password: &nbsp;</label>
                <input
                    type="text"
                    name="confirmPassword"
                    placeholder="Confirm your chosen password"
                    value={confirmPassword}
                    onChange={event => setConfirmPassword(event.target.value)}
                />
            </div>
            <div className="form-group">
                <input type="submit" className="btn" value="Sign Up"  />
            </div>
        </form>
            {userid != 0 ? <Button onClick={createSubscription}>Checkout</Button> : <></>}

    </>
    );
};

//SignUpForm.propTypes = {
//    submitForm: PropTypes.func.isRequired}

export default SignUpForm;