import React from "react";

import { Routes, Route } from "react-router-dom";
import Profile from "./Profile";
import About from "./About";
import SignUp from "./SignUp";
import RecommendedDestinations from "./RecommendedDestinations";
import TravelSearch from "./TravelSearch";
import NotFound404 from "./NotFound";
import EntryPage from "./EntryPage";
import Home from "./Home";
import SignUpForm from "./SignUpForm";
import LogIn from "./LogIn";
import TravelInfo from "./TravelInfo";

function RouteList() {
    return (
        <div>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/about" element={<About />} />
                <Route path="/profile" element={<Profile />} />
                <Route path="/recommendedDestinations" element={<RecommendedDestinations />} />
                <Route path="/travelSearch" element={<TravelSearch />} />
                <Route path="*" element={<NotFound404 />} />
                <Route path="/signUp" element={<SignUp />} />
                <Route path="/entryPage" element={<EntryPage />} />
                <Route path="/signUpForm" element={<SignUpForm />} />
                <Route path="/logIn" element={<LogIn />} />
                <Route path="/travelInfo" element={<TravelInfo />} />
            </Routes>
        </div>
    );
}
export default RouteList;