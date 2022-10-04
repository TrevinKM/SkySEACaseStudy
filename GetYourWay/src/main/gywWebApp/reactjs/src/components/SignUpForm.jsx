import React, { useState } from 'react';
import PropTypes from 'prop-types';

const SignUpForm = props => {

    const usersUrl = 'http://localhost:3000/users';

    const [firstName, setFirstName] = useState(``);
    const [lastName, setLastName] = useState(``);
    const [emailAddress, setEmailAddress] = useState(``);
    const [password, setPassword] = useState(``);
    const [confirmPassword, setConfirmPassword] = useState(``);

    const handleSubmit = event => {
        event.preventDefault();
        props.submitForm(firstName, lastName, emailAddress, password)
        setFirstName(``);
        setLastName(``);
        setEmailAddress(``);
        setPassword(``);
    }

    const submitForm = async event => {
        event.preventDefault();
        const body = JSON.stringify({firstName, lastName, emailAddress, password});
        const requestOptions = {
            method: `POST`,
            headers: { 'Content-Type': 'application/json' },
            body
        };
        const response = await fetch(usersUrl, requestOptions);
        const result = await response.json();
        console.log(result);
    }

    return (
        <form onSubmit={handleSubmit}>
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
                    value={emailAddress}
                    onChange={event => setEmailAddress(event.target.value)}
                />
            </div>

            <div className="form-group">
                <label htmlFor="password">Password: &nbsp;</label>
                <input
                    type="text"
                    name="password"
                    placeholder="Password needs to be at least 8 characters"
                    value={password}
                    onChange={event => setPassword(event.target.value)}
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
    );
};

//SignUpForm.propTypes = {
//    submitForm: PropTypes.func.isRequired}

export default SignUpForm;