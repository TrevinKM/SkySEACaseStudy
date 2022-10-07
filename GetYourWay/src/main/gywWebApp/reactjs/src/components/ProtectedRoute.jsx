import React from "react";
import { Navigate } from 'react-router-dom';

const RequireAuth = ({authenticated, children}) =>{
    console.log(authenticated);
    if(authenticated == -1){
        return <p>loading...</p>
    }

    return(
        authenticated == 1 ? (
            children
        ) : (
            <Navigate to={"/login"} replace />
        )
    )
};

export default RequireAuth