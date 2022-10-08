import React from 'react';
import Carousel from 'react-bootstrap/Carousel';
import { useNavigate } from 'react-router-dom';

export default function BootstrapCarousel() {

    const navigate = useNavigate()

    function handleClick(iata) {
        //e.preventDefault();
        console.log(iata)
        navigate('/travelInfo', {state: {destination: iata}})
    }

    return (
        <div id="carouselWrapper">

            <Carousel fade variant="dark">
            <Carousel.Item>
            <img
            className="d-block w-100"
            style={{height : 500}}
            src="/images/1dest.jpeg"
            alt="First slide"
            onClick={() => {handleClick("Belfast")}}
            />
            <Carousel.Caption>
            <h3><strong>Belfast, Northern Ireland</strong></h3>
                    <p><strong>Visit Belfast for its vibrant culture and explore the nearby coast and
                            countryside to marvel at the spectacular locations from Game of Thrones.</strong></p>
            </Carousel.Caption>
            </Carousel.Item>
            <Carousel.Item>
                    <img
                        className="d-block w-100"
                        style={{height : 500}}
                        src="/images/2dest.jpeg"
                        alt="Second slide"
                        onClick={() => {handleClick('Nice')}}
                    />

            <Carousel.Caption>
            <h3><strong>Nice, France</strong></h3>
            <p><strong>Start your own Riviera adventure from Nice. Dive into Azure seas and
                    experience breathtaking clifftop drives.</strong></p>
            </Carousel.Caption>
            </Carousel.Item>
            <Carousel.Item>
            <img
            className="d-block w-100"
            style={{height : 500}}
            src="/images/3dest.jpeg"
            alt="Third slide"
            onClick={() => {handleClick('Monterey')}}
            />

            <Carousel.Caption>
            <h3><strong>Monterey, U.S.</strong></h3>
            <p><strong>Step into an enviable lifestyle. Surf or simply relax on deserted beaches,
                    See the spectacular Monterey Bay Aquarium and pause for coffee at Palace
                    Trattoria - the real Blue Blues Cafe.</strong>
            </p>
            </Carousel.Caption>
            </Carousel.Item>
            </Carousel>
        </div>
    )
}