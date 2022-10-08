import React from 'react';
// import logo from "../logo.png";
import logo from "./logo.png";
import skyLogo from "./skyLogo.png";
import {Link} from 'react-router-dom';
import LogOut from "./LogOut";


import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';

function NavBar() {
  return (
    <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark" className={"mb-3"}>
      <Container>
        <Navbar.Brand href="/">
        <img src={skyLogo} alt="Sky logo" style={{width: '60px', paddingRight: '20px'}} className="d-inline-block align-text-top"/>
            Get Your Way
                </Navbar.Brand>
        <Navbar.Toggle aria-controls="responsive-navbar-nav" />
        <Navbar.Collapse id="responsive-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href="/about">About</Nav.Link>
            <Nav.Link href="/travelSearch">Travel Search</Nav.Link>
            <Nav.Link href="/recommendedDestinations">Recommended Destinations</Nav.Link>
          </Nav>
          <Nav>
            <Nav.Link href="/profile">Profile</Nav.Link>
            <LogOut />
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );

}
export default NavBar;
