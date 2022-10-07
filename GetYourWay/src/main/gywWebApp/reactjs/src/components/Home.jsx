import React from "react";
import BootstrapCarousel from "./BootstrapCarousel";
import Header from "./Header";

export function Home() {
    return (
        <>
        <p><Header /></p>

        <div>
            <BootstrapCarousel />
        </div>

        </>
    );
}

export default Home;