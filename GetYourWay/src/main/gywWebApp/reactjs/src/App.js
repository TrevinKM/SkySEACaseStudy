import React from 'react';
/*import { Route } from 'react-router-dom';*/
/*import { Switch } from 'react-js-switch';*/
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap';
import './App.css';

import Header from "./components/Header";
import Footer from "./components/Footer";
import NavBar from './components/NavBar';
import RecommendedDestinations from './components/RecommendedDestinations';
import Profile from './components/Profile';

function App() {
  return (
      <>
          <NavBar />
          <div className="content">

            {/*routing*/}
              {/*<Switch>*/}
              {/*    <Route path="/travelSearch" component={TravelSearch} />*/}
              {/*    <Route path="/login" component={Login} />*/}
              {/*    <Route path="/signup" component={SignUp} />*/}
              {/*    <Route path="/profile" component={Profile} />*/}
              {/*    <Route path="/recommendedDestinations" component={RecommendedDestinations} />*/}
              {/*    <Route path="/" component={Home} />*/}
              {/*</Switch>*/}

          </div>
          <Header />
          <main className="container">
            <Profile />
            <RecommendedDestinations />
          </main>
          <Footer />
      </>
  );
}

export default App;
