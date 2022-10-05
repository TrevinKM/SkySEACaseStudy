import React, { useState } from 'react';

const LogIn = () => {

    const [emailAddress, setEmailAddress] = useState('');
    const [password, setPassword] = useState('');

    const printValues = e => {
        e.preventDefault();
        console.log(emailAddress, password);
    }

    return (
        <>
            <form onSubmit={printValues}>
                <label>Email Address:</label>
                <input name = "emailAddress"
                       type="text"
                       value={emailAddress}
                       onChange={e => setEmailAddress(e.target.value)} />
                <label>Password: </label>
                <input type="password"
                       name="password"
                       value={password}
                       onChange={e => setPassword(e.target.value)} />
                <br/>
                <button>Submit</button>
            </form>
        </>
    );
}

export default LogIn;
