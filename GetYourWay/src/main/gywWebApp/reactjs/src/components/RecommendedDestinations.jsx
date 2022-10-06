import React from 'react';
import {destinationData} from './recommended_destinations';
import { useEffect } from 'react';
import { useState } from 'react';
import axios from 'axios';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';



const RecommendedDestinations = () => {
    return (
        <>
        <p>
        <h4>Get Inspired by Sky Movie and Show Locations</h4>
        </p>
        <Container>
        <Row>

            {destinationData.map((data, key) => {
                return (<>
                       
                        <Card style={{ width: '18rem' }}>
                        <Card.Header>{data.sky_show}</Card.Header>
                            <Card.Img variant="top" className="smallimg" src={"images/" + data.id + "show.jpeg"} alt= {"Picture of " + data.sky_show}/>
                            <Card.Header>Destination: {data.name}</Card.Header>
                            <Card.Img variant="top" className="smallimg" src={"images/" + data.id + "dest.jpeg"} alt= {"Picture of " + data.name} />  
                                <Card.Body>
                                    <Card.Title></Card.Title>
                                    <Card.Title></Card.Title>
                                    
                                    <Card.Text>
                                    {data.destination_info}
                                    </Card.Text>
                                    <Button variant="secondary">Find flights to {data.arrivaliatacode} </Button>
                              </Card.Body>
                        </Card>                  
                    
                </>
                    
                )
            }
            )
            }
       </Row>
    </Container>
    </>
);
}  
export default RecommendedDestinations;

// const RecommendedDestinations = () => {
//     const [recommendedDestination, setRecommendedDestination] = useState([]);

//     useEffect(() => {
//         const getRecommendedDestination = async () => {
//             let response = await axios.get('http://localhost:8082/recommendedDestination/showAll');
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