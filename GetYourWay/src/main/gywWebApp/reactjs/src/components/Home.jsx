import {Link} from "react-router-dom";
import React from "react";
import BootstrapCarousel from "./BootstrapCarousel";
import Header from "./Header";
import line from "../line.png";

export function Home() {
    return (
        <>

        <div>
            <BootstrapCarousel />
        </div>

        </>
    );
}

export default Home;