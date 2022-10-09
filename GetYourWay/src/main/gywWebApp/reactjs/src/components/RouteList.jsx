import React, {useEffect, useState} from "react";
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
import RequireAuth from "./ProtectedRoute";
import TravelInfo from "./TravelInfo";
import LogOut from "./LogOut";

function RouteList({authenticated, setAuthenticated}) {
    return (
        <div>
            <Routes>
                <Route path="/about" element={<About />}/>
                <Route path="/" element={<Home />} />
                {/*<Route path="/" element={<RequireAuth authenticated={authenticated}><Home /></RequireAuth>} />*/}
                <Route path="/profile" element={<RequireAuth authenticated={authenticated}><Profile /></RequireAuth>} />
                <Route path="/recommendedDestinations" element={<RecommendedDestinations />} />
                {/*<Route path="/recommendedDestinations" element={<RequireAuth authenticated={authenticated}><RecommendedDestinations /></RequireAuth>} />*/}
                {/*<Route path="/travelSearch" element={<RequireAuth authenticated={authenticated}><TravelSearch /></RequireAuth>} />*/}
                <Route path="/travelSearch" element={<TravelSearch />} />
                <Route path="*" element={<NotFound404 />}/>
                <Route path="/signUp" element={<SignUp />} />
                <Route path="/entryPage" element={<RequireAuth authenticated={authenticated}><EntryPage /></RequireAuth>} />
                <Route path="/signUpForm" element={<SignUpForm />} />
                <Route path="/logIn" element={<LogIn setAuthenticated={setAuthenticated}/>} />
                <Route path="/travelInfo" element={<TravelInfo />} />
            </Routes>
        </div>
    );
}
export default RouteList;