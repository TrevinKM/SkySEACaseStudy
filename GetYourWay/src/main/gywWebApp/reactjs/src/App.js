// import Header from "./components/Header";
// import Footer from "./components/Footer";
// import NavBar from './components/NavBar';
// import RecommendedDestinations from './components/RecommendedDestinations';
// import Profile from './components/Profile';
// import SignUp from './components/SignUp';
// import LogIn from "./components/LogIn";
// import TravelSearch from "./components/TravelSearch";
// import SignUpForm1 from "./components/SignUpForm1";
// import submitSignUpForm from "./components/SubmitSignUpForm1";
// import SignUpForm from "./components/SignUpForm";

// function App() {
//   return (
//       <>
//           <NavBar />
//           <div className="content">
//
//
//           </div>
//           <Header />
//           <main className="container">
//             <Profile />
//             <RecommendedDestinations />
//               <SignUp />
//               <LogIn />
//               <TravelSearch />
//               {/*<SignUpForm1 submitSignUpForm1={submitSignUpForm}/>*/}
//               <SignUpForm submitSignUpForm={} />
//
//           </main>
//           <Footer />
//       </>
//   );
// }

import React from 'react';
import { Routes, Route } from "react-router-dom";
import {add
    Home,
    About,
    Profile,
    RecommendedDestinations2,
    TravelSearch,
    NotFound404
} from './pages';
import NavBar from "./components/NavBar";
import Footer from "./components/Footer";
import SignUpForm from "./components/SignUpForm";

function App() {
    return (
        <>
        <NavBar />
            <div>

            </div>
            <SignUpForm />
            <Footer />
        </>
    );
}

export default App;

/*
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/about" element={<About />} />
                    <Route path="/profile" element={<Profile />} />
                    <Route path="/recommendedDestinations" element={<RecommendedDestinations2 />} />
                    <Route path="/travelSearch" element={<TravelSearch />} />
                    <Route path="*" element={<NotFound404 />} />
                </Routes>
 */