import React, { useState } from 'react';

const LogIn = () => {

    const [emailAddress, setEmailAddress] = useState('');
    const [password, setPassword] = useState('');

    return (
        <>
            <form method="post" action="http://localhost:8082/login">
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
