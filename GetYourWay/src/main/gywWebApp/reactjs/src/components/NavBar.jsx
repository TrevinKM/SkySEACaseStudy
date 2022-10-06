import React from 'react';
import logo from "../logo.png";
import skyLogo from "./skyLogo.png";
import {Link} from 'react-router-dom';
import LogOut from "./LogOut";

const NavBar = () => {
    return (
        <nav className="navbar navbar-expand-md navbar-dark bg-dark mb-4">
            <div className="container-fluid">
                <a className="navbar-brand" href="/">
                    <img src={skyLogo} alt="Get Your Way logo" style={{width: '25px'}}

                         className="d-inline-block align-text-top"/>
                    Get Your Way</a>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false"
                        aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarCollapse">
                    <ul className="navbar-nav me-auto mb-2 mb-md-0">
                        <li className="nav-item">
                            <Link className="nav-link active" aria-current="page" to="/">Home</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/about">About Get Your Way</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/profile">My Profile</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/travelSearch">Travel Search</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/recommendedDestinations">Recommended Destinations</Link>
                        </li>
                    </ul>
                </div>
                <LogOut />
            </div>
        </nav>
    );
}

export default NavBar;