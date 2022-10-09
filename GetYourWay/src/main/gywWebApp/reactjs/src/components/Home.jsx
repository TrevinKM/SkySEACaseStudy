import React from "react";
import BootstrapCarousel from "./BootstrapCarousel";
import Header from "./Header";

export function Home() {
    return (
        <>
            <center>
                <p><Header /></p>
            </center>

            <div>
                <BootstrapCarousel />
            </div>

        </>
    );
}

export default Home;