import React from 'react';
import {sample_users} from './sample_users';

const UserDetails = () => {
    return (
    
        <>
        {sample_users.map((data, key) => {
            return (<>
                        
                        <p>First name: {data.first_name}</p>
                        <p>Last name: {data.last_name}</p>
                        <p>E-mail: {data.email_address}</p>
                                
                    </>
            )
        }
        )
        }
        </>
    );
}
export default UserDetails;