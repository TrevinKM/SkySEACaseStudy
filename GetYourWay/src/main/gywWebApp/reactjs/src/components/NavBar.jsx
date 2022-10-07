import React from 'react';
// import logo from "../logo.png";
import logo from "./logo.png";
import skyLogo from "./skyLogo.png";
import {Link} from 'react-router-dom';

import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';

function NavBar() {
  return (
    <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
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
            <Nav.Link href="/logOut">Logout</Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}
export default NavBar;
// const NavBar = () => {
//     return (
//     <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
//       <Container>
//             <nav className="navbar navbar-expand-md navbar-dark bg-dark mb-4">
//             <div className="container-fluid">
//                 <a className="navbar-brand" href="/">
//                     <img src={skyLogo} alt="Sky logo" style={{width: '60px', paddingRight: '20px'}}
//                          className="d-inline-block align-text-top"/>
//                          <strong>Get Your Way</strong></a>
//                 <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
//                         data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false"
//                         aria-label="Toggle navigation">
//                     <span className="navbar-toggler-icon"></span>
//                 </button>
//                 <div className="collapse navbar-collapse" id="navbarCollapse">
//                     <ul className="navbar-nav me-auto mb-2 mb-md-0">
//                         <li className="nav-item">
//                             <Link className="nav-link active" aria-current="page" to="/">Home</Link>
//                         </li>
//                         <li className="nav-item">
//                             <Link className="nav-link" to="/about">About</Link>
//                         </li>
//                         <li className="nav-item">
//                             <Link className="nav-link" to="/profile">My Profile</Link>
//                         </li>
//                         <li className="nav-item">
//                             <Link className="nav-link" to="/travelSearch">Travel Search</Link>
//                         </li>
//                         <li className="nav-item">
//                             <Link className="nav-link" to="/recommendedDestinations">Recommended Destinations</Link>
//                         </li>
//                     </ul>
//                 </div>
//             </div>
//         </nav>
//         </Container>
//         </Navbar>
//     );
// }

