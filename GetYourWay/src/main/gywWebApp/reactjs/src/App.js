import React from 'react';
// import { BrowserRouter, Routes, Route } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap';
import './App.css';

import Header from "./components/Header";
import Footer from "./components/Footer";
import NavBar from './components/NavBar';
import RecommendedDestinations from './components/RecommendedDestinations';
import Profile from './components/Profile';
import SignUp from './components/SignUp';
import LogIn from "./components/LogIn";
import TravelSearch from "./components/TravelSearch";

function App() {
  return (
      <>
          <NavBar />
          <div className="content">

              {/*<BrowserRouter>*/}
              {/*    <Routes>*/}
              {/*        <Route path="/travelSearch" component={TravelSearch} />*/}
              {/*        <Route path="/login" component={LogIn} />*/}
              {/*        <Route path="/signup" component={SignUp} />*/}
              {/*        <Route path="/profile" component={Profile} />*/}
              {/*        <Route path="/recommendedDestinations" component={RecommendedDestinations} />*/}
              {/*  </Routes>*/}
              {/*</BrowserRouter>*/}

          </div>
          <Header />
          <main className="container">
            <Profile />
            <RecommendedDestinations />
              <SignUp />
              <LogIn />
              <TravelSearch />
          </main>
          <Footer />
      </>
  );
}

export default App;
