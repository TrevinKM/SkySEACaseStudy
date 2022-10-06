import {Link} from "react-router-dom";
import React from "react";
import BootstrapCarousel from "./BootstrapCarousel";
import Header from "./Header";
import line from "../line.png";

export function Home() {
    return (
        <>
        <div>
            <img
                src={line}
                alt="rainbow line"
                style={{width: '1450px'}}
            />
            <h1>Welcome to</h1>
            <Header />
            <nav>
                <Link to="about" >About</Link>
                <Link to="entryPage">Entry Page</Link>
                <Link to="recommendedDestinations" >Recommended Destinations</Link>
                <Link to="profile">Profile</Link>
                <Link to="travelSearch" >Travel Search</Link>
            </nav>
        </div>

        <div>
            <BootstrapCarousel />
        </div>
        </>
    );
}

export default Home;