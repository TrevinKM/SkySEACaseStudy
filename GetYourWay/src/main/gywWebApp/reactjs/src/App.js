import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap';
import './App.css';

import Header from "./components/Header";
import Footer from "./components/Footer";

function App() {
  return (
    <div className="App">
        <Header />
        <p>
            Hello, do you want to Get Your Way?
        </p>
        <Footer />
    </div>
  );
}

export default App;
