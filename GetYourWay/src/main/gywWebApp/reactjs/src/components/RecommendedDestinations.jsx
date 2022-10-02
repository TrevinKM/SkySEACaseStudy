import React from 'react';
import recommended_destinations from './recommended_destinations.json';

const RecommendedDestinations = () => {
    return (
        <p>
            {JSON.stringify(recommended_destinations)}
        </p>
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