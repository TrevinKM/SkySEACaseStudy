import React from 'react';
import {Link, useLocation} from 'react-router-dom';
import { useNavigate, useParams } from "react-router-dom";
import { Outlet } from 'react-router-dom';
import UserDetails from "./components/UserDetails";
import SavedJourney from "./components/SavedJourney";
import RecommendedDestinations from "./components/RecommendedDestinations";


export function Home() {
    return (
        <div>
            <h1>[Get Your Way]</h1>
            <nav>
                <Link to="about" >About</Link>
                <Link to="recommendedDestinations" >Recommended Destinations</Link>
                <Link to="profile">Profile</Link>
                <Link to="travelSearch" >Travel Search</Link>
            </nav>
        </div>
    );
}

export function About(){
    return (
        <div>
            <h1>[About]</h1>
            <Outlet />
            <p>Here is some information about Get Your Way</p>
        </div>
    );
}

export function RecommendedDestinations2() {
    return (
        <div>
            <h1>[RecommendedDestinations]</h1>
            <RecommendedDestinations />
        </div>
    );
}

export function Profile(){
    let navigate = useNavigate();
    let { firstName } = useParams();

    return (
        <div>
            <h1>[Profile]</h1>
            <h1>This is the profile page for { firstName } </h1>
            <UserDetails />
            <SavedJourney />
            <button onClick={() => {navigate("/about")}}>About Page</button>
        </div>

    )
}

export function TravelSearch(){
    return (
        <div>
            <h1>[TravelSearch]</h1>
            <>
                <p>Flights API</p>
                <p>Weather API</p>
                <p>Journey Details</p>
            </>
        </div>
    )
}


export function NotFound404(){
    let location = useLocation();
    console.log(location);
    return (
        <div>
            <h1>Resource not found at {location.pathname}</h1>
        </div>
    );
}