import React, { useState } from 'react';
import axios from "axios";
import { useNavigate } from "react-router-dom";

const LogIn = ({setAuthenticated}) => {

    const [emailAddress, setEmailAddress] = useState('');
    const [password, setPassword] = useState('');
    let navigate = useNavigate();
    const submitForm = async event => {
        event.preventDefault();
        axios.post('http://localhost:8082/user_login',{
            email: emailAddress,
            password: password
        }).then(response => {
                let user_id = 0;
                localStorage.removeItem("logged_in_as");
                localStorage.setItem("logged_in_as", response.data);
                setAuthenticated(1);
                navigate("/");
            }
        );
    }
    return (
        <>
            <form onSubmit={submitForm}>
                <label>Email Address:</label>
                <input name="email"
                       type="text"
                       value={emailAddress}
                       onChange={e => setEmailAddress(e.target.value)} />
                <label>Password: </label>
                <input type="password"
                       name="password"
                       value={password}
                       onChange={e => setPassword(e.target.value)} />
                <br/>
                <input type="submit" value="submit" />
            </form>
        </>
    );
}

export default LogIn;
