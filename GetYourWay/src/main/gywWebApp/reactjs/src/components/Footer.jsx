import React from 'react';
import {Container} from "react-bootstrap";
import line from "../line.png";

const Footer = () => {
    return (
        <>
        <img
                src={line}
                alt="rainbow line"
                style={{width: '100%'}}
            />
        <Container>
                           
        

            <footer className="mt-auto py-3 container text-center">
                &copy; Sky Ltd - Software Engineering Academy 2022 <br/>
            </footer>
            
        </Container>
        </>
    );
};
export default Footer;