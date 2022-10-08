import React, {useEffect, useState} from 'react';
import NavBar from "./components/NavBar";
import Footer from "./components/Footer";
import RouteList from "./components/RouteList";

function App() {
    const [authenticated, setAuthenticated] = useState(-1);

    useEffect(() =>{
        if(localStorage.getItem("logged_in_as") != null){
            setAuthenticated(1);
        } else{
            setAuthenticated(0);
        }
    }, []);

    return (
        <>
            <NavBar/>
            <RouteList authenticated={authenticated} setAuthenticated={setAuthenticated} />
            <Footer />
        </>
    );
}

export default App;
