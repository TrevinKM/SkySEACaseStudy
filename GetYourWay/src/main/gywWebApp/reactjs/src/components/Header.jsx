import React from 'react';
import {Link, Route} from "react-router-dom";
import RecommendedDestinations from "./RecommendedDestinations";

const Header = () => {
    return (
        <header style={{paddingTop: '15px', paddingBottom: '15px'}}>
                <h3>Start your adventure here...</h3>
                <p>Be inspired and browse through our
                     <Link to={"/recommendedDestinations"}
                          element={ RecommendedDestinations } >
                    Recommended Destinations </Link> from Sky shows you love!
        </p>
        </header>
    );
};

export default Header;