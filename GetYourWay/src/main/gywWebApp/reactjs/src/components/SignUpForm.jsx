import React, { useState } from 'react';

const SignUpForm = () => {

    // const usersUrl = 'http://localhost:3000/users';

    const [firstName, setFirstName] = useState(``);
    const [lastName, setLastName] = useState(``);
    const [emailAddress, setEmailAddress] = useState(``);
    const [password, setPassword] = useState(``);
    const [confirmPassword, setConfirmPassword] = useState(``);

    // const handleSubmit = event => {
    //     event.preventDefault();
    //     setFirstName(``);
    //     setLastName(``);
    //     setEmailAddress(``);
    //     setPassword(``);

        const saveFormData = async () => {
            const response = await fetch('http://localhost:3000/save', {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify({firstName, lastName, emailAddress, password, confirmPassword})
            });
            if (response.status !== 200){
                throw new Error(`Request failed: ${response.status}`);
            }
        }

        const onSubmit = async (event) => {
            event.preventDefault();
            try {
                await saveFormData();
                alert('Your registration was successfully submitted!');
                setFirstName('');
                setLastName('');
                setEmailAddress('');
                setPassword('');
            } catch (e) {
                alert(`Registration failed! ${e.message}`);
            }
        }



        // const submitForm = async event => {
        //     event.preventDefault();
        //     const body = JSON.stringify({firstName, lastName, emailAddress, password});
        //     const requestOptions = {
        //         method: `POST`,
        //         headers: {'Content-Type': 'application/json'},
        //         body
        //     };
        //     const response = await fetch(usersUrl, requestOptions);
        //     const result = await response.json();
        //     console.log(result);
        // }

        return (
            <form onSubmit={onSubmit}>
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
                    <input type="submit" className="btn" value="Sign Up"/>
                </div>
            </form>
        );
}

export default SignUpForm;