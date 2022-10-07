import {Link} from "react-router-dom";
import React from "react";
import BootstrapCarousel from "./BootstrapCarousel";
import Header from "./Header";
import line from "../line.png";
import SearchBar from "./SearchBar";

export function Home() {
    return (
        <>
        <div>
           
            <h3>Welcome to</h3>
            <Header />
            <SearchBar />
        </div>

        <div>
            <BootstrapCarousel />
        </div>
        <div>
        <img
                src={line}
                alt="rainbow line"
                style={{width: '1450px'}}
            />
        </div>
        </>
    );
}

export default Home;