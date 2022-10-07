import React, { useState } from 'react';
import { useNavigate } from "react-router-dom";

const LogOut = () => {
    let navigate = useNavigate();
    const logOut = async event => {
        localStorage.removeItem("logged_in_as");
        navigate("/login");
    }

        if(localStorage.getItem("logged_in_as") != null){
            return(<a onClick={logOut} style={{color: "red"}}>Log Out</a>)
        }

        else return<></>}

export default LogOut;
