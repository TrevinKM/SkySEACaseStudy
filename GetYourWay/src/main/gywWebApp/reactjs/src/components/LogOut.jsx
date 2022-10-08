import React, { useState } from 'react';
import { useNavigate } from "react-router-dom";
import {NavLink} from "react-bootstrap";

const LogOut = () => {
        let navigate = useNavigate();
        const logOut = async event => {
            localStorage.removeItem("logged_in_as");
            navigate("/login");
        }

        if(localStorage.getItem("logged_in_as") != null){
            return(<NavLink onClick={logOut}>Log Out</NavLink>)
        }

        else return<></>}

export default LogOut;
