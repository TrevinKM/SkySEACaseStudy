import React from 'react';
import {destinationData} from './recommended_destinations';
import { useEffect } from 'react';
import { useState } from 'react';
import axios from 'axios';


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
                        Destination
                    </th>
                    <th>
                        Real Life
                    </th>
                </tr>

            {destinationData.map((data, key) => {
                return (<>
                    <tr>
                        <td>
                            {data.sky_show}
                        </td>
                        <td>
                            
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <img className="smallimg" src={"images/" + data.id + "show.jpeg"} alt= {"Picture of " + data.sky_show} />
                        </td>
                        <td>
                        {data.name} - nearest airport {data.arrivaliatacode}<br/>
                        {data.destination_info}
                        </td>
                        <td>
                            <img className="smallimg" src={"images/" + data.id + "dest.jpeg"} alt= {"Picture of " + data.name} />
                        </td>

                    </tr>
                    <tr>
                        
                            
                    
                    </tr>
                    <tr>
                        <td>
                            <tr>
                            </tr>
                        </td>
                    </tr>
                </>
                    
                )
            }
            )
            }
        </table>
        </div>
    </>
);
}  
export default RecommendedDestinations;

// const RecommendedDestinations = () => {
//     const [recommendedDestination, setRecommendedDestination] = useState([]);

//     useEffect(() => {
//         const getRecommendedDestination = async () => {
//             let response = await axios.get('http://18.169.58.161:8082/recommendedDestination/showAll');
//             let destinationdata = await response.data;
//             console.log(destinationdata);
//             setRecommendedDestination(destinationdata);
//         };
//         getRecommendedDestination();
//     }, []);
//     return (
//         <>
//         <h2>Get Inspired by Movie and Show Locations</h2>
//         <div>
//             <table>
//                 <tr>
//                     <th>
//                         On Screen
//                     </th>
//                     <th>
//                         Real Life
//                     </th>
//                 </tr>

//             {recommendedDestination.map((data, key) => {
//                 return (<>
//                     <tr>
//                         <td>
//                             {data.sky_show}
//                         </td>
//                         <td>
//                             {data.name} - nearest airport {data.arrivaliatacode}
//                         </td>
//                     </tr>
//                     <tr>
//                         <td>
//                             <img className="smallimg" src={"images/" + data.id + "show.jpeg"} alt= {"Picture of " + data.sky_show} />
//                         </td>
//                         <td>
//                             <img className="smallimg" src={"images/" + data.id + "dest.jpeg"} alt= {"Picture of " + data.name} />
//                         </td>

//                     </tr>
//                     <tr>
//                         <td rowspan="2">
//                             {data.destination_info}
//                         </td>
//                     </tr>
//                     <tr>
//                         <td>
//                             <tr>
//                             </tr>
//                         </td>
//                     </tr>
//                 </>
                    
//                 )
//             }
//             )
//             }
//         </table>
//         </div>
//     </>
// );
// }  