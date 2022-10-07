import React from 'react';
import logo from '../logo.png';

const Header = () => {
    return (
        <header>
            <nav className="navbar navbar-expand-sm">
                <a
                    href="https://getyourway.com"
                    className="navbar-brand"
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    {/* <img
                        src={logo}
                        alt="Get Your Way"
                        style={{width: '100px'}}
                    /> */}
                </a>
                <a className="navbar-brand" href="/">
                    <h1>Get Your Way</h1>
                </a>
            </nav>
        </header>
    );
};

export default Header;