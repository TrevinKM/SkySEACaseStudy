import React from 'react';
import {Container} from "react-bootstrap";
import line from "../line.png";

const Footer = () => {
    return (
        <>
            <footer className="mt-auto position-relative text-center">
                <div>
                    <img
                        src={line}
                        alt="rainbow line"
                        style={{width: '100%'}}
                    />
                </div>
                <div>
                    &copy; Sky Ltd - Software Engineering Academy 2022 <br/>
                </div>
            </footer>
        </>
    );
};
export default Footer;