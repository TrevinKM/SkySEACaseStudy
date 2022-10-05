import React from 'react';
import { Link } from "react-router-dom";

const EntryPage = () => {
    return (
        <>
            <h1>Sky Platform</h1>
            <nav>
                <Link to={"/signUpForm"}> Sign Up </Link>
                <Link to={"/logIn"}> Log In </Link>
            </nav>
        </>
    );
}


export default EntryPage;