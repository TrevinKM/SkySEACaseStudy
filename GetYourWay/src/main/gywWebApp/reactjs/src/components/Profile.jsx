import React from "react";
import UserDetails from "./UserDetails";
import SavedJourney from "./SavedJourney";

const Profile = () => {
    return (
        <>
            <h3>Your Details</h3>
            <UserDetails/>
            <h3>Your Saved Journeys</h3>
            <SavedJourney/>
        </>
    );
}

export default Profile;