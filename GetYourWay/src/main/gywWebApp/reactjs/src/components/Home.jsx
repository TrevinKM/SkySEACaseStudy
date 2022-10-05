import {Link} from "react-router-dom";
import React from "react";

export function Home() {
    return (
        <div>
            <h1>[Get Your Way]</h1>
            <nav>
                <Link to="about" >About</Link>
                <Link to="entryPage">Entry Page</Link>
                <Link to="recommendedDestinations" >Recommended Destinations</Link>
                <Link to="profile">Profile</Link>
                <Link to="travelSearch" >Travel Search</Link>
            </nav>
        </div>
    );
}

export default Home;