import {Link} from "react-router-dom";
import React from "react";
import BootstrapCarousel from "./BootstrapCarousel";
import Header from "./Header";
import SearchBar from "./SearchBar";

export function Home() {
    return (
        <>
        <p><Header /></p>
            <div>
                <SearchBar />
            </div>

        <div>
            <BootstrapCarousel />
        </div>

        </>
    );
}

export default Home;