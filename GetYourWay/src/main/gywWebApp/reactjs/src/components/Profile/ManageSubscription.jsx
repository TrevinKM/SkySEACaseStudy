import React from 'react';
import {useState, useEffect} from "react";
import axios from "axios";
import {Col, Container, Row, Form, Button} from "react-bootstrap";
const ManageSubscription = () => {
    const [portal, setPortal] = useState('');
    useEffect(() => {
        axios.get(`${process.env.REACT_APP_SPRING_ROOT}/subscription/portal?customer_id=${localStorage.getItem('logged_in_as')}`).then(
            response => {setPortal(response.data)}
        ).catch(error => console.log(error));
    },[]);

    return (
        <>
            <h4>Manage Subscription</h4>
            <a href={portal}>Click to here manage your subscription</a>
        </>
    )
}
export default ManageSubscription;
