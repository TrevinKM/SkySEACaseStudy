import React from 'react';
import sample_users from './sample_users.json';

const UserDetails = () => {
    return (
        <p>
            {JSON.stringify(sample_users)}
        </p>
    );
}
export default UserDetails;