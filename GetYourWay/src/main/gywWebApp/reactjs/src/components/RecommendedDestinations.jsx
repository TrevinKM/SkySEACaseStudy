import React from 'react';
//import {destinationData} from './recommended_destinations';
import { useEffect } from 'react';
import { useState } from 'react';
import axios from 'axios';

const RecommendedDestinations = () => {
    const [recommendedDestination, setRecommendedDestination] = useState([]);

    useEffect(() => {
        const getRecommendedDestination = async () => {
            let response = await axios.get('http://localhost:8082/recommendedDestination/showAll');
            let destinationdata = await response.data;
            console.log(destinationdata);
            setRecommendedDestination(destinationdata);
        };
        getRecommendedDestination();
    }, []);
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

            {recommendedDestination.map((data, key) => {
                return (<>
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
                            <img class="smallimg" src={"images/" + data.id + "show.jpeg"} alt= {"Picture of " + data.sky_show} />
                        </td>
                        <td>
                            <img class="smallimg" src={"images/" + data.id + "dest.jpeg"} alt= {"Picture of " + data.name} />
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

