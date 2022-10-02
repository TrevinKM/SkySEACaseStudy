import React from 'react';
import {destinationData} from './recommended_destinations';

const RecommendedDestinations = () => {
    return (
        <>
        <h2>Get Inspired by Movie and Show Locations</h2>
        <div>
            <table>
                <tr>
                    <th>
                        On Screen
                    </th>
                    <th>
                        Real Life
                    </th>
                </tr>
            {destinationData.map((data, key) => {
                return (
                    <>
                    <tr>
                        <td>
                        {data.sky_show}
                        </td>
                        <td>
                        {data.name} - nearest airport {data.arrivaliatacode}  
                        </td>
                    </tr>
                    <tr>
                    <td>
                            <img class = "smallimg" src={"images/" + data.id + "show.jpeg"} alt= {"Picture of " + data.sky_show} />
                        </td>
                        <td>
                            <img class = "smallimg" src={"images/" + data.id + "dest.jpeg"} alt= {"Picture of " + data.name} />
                        </td>
                
                    </tr>
                    <tr>
                        <td rowspan="2">
                        {data.destination_info}   
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <tr>     
                            </tr>
                        </td>
                    </tr>
                    </>
                );
            })}
            </table>
        </div>
        </>
    );
}

{/*}
const RecommendedDestinations = () => {
    const allDestinations = recommended_destinations.map(data=>
        <p item={data} key={data.id} />);
        return (
            <>
                <h2>We recommend visiting</h2>
                <div>
                    {allDestinations}
                </div>
            </>
        );
};
*/}

export default RecommendedDestinations;
// potential code for when static data exists in file


// import React, { Component } from 'react';
// import "./App.css";
//
// // need to import the static data for recommended destinations
// // import { nameOfGetterForRecommendedDestinations } from 'folder';
//
// const RecommendedDestinations = () => {
//
//     return (
//         <table className="table">
//             <thead>
//             <tr>
//                 <th>Destination Name</th>
//                 <th>Destination Information</th>
//                 <th>Sky Show</th>
//                 <th>Arrival Location</th>
//             </tr>
//             </thead>
//             <tbody>
//             { this.state.recommendedDestinations.map(recommendedDestination => <tr>
//                 <td>{recommendedDestination.destinationName}</td>
//                 <td>{recommendedDestination.destinationInformation}</td>
//                 <td>{recommendedDestination.skyShow}</td>
//                 <td>{recommendedDestination.arrivalLocation}</td>
//             </tr>)}
//
//             </tbody>
//         </table>
//     )
// };
//
// export default RecommendedDestinations;