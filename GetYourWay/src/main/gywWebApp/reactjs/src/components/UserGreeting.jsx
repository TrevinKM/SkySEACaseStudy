import React from "react";


const UserGreeting = props => {
    
    useEffect(() => {
         const getUser = async () => {
             let response = await axios.get('http://localhost:8082/user/' + localStorage.getItem("logged_in_as"));
             let userdata = await response.data;
            };
         getUser();
     }, []);
return (
         {userdata.firstName}
           )
 }


export default UserGreeting;