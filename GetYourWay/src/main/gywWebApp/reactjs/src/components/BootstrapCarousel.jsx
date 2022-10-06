import React from 'react';
import Carousel from 'react-bootstrap/Carousel';

export default function BootstrapCarousel() {
    return (
        <div id="carouselWrapper">

            <Carousel fade variant="dark">
            <Carousel.Item>
            <img
            className="d-block w-100"
            style={{height : 500}}
            src="/images/1dest.jpeg"
            alt="First slide"
            />
            <Carousel.Caption>
            <h3>Belfast, Northern Ireland</h3>
            <p>Visit Belfast for its vibrant culture and explore the nearby coast and countryside to marvel at the spectacular locations from Game of Thrones.</p>
            </Carousel.Caption>
            </Carousel.Item>
            <Carousel.Item>
                    <img
                        className="d-block w-100"
                        style={{height : 500}}
                        src="/images/2dest.jpeg"
                        alt="Second slide"
                    />

            <Carousel.Caption>
            <h3>Nice, France</h3>
            <p>Start your own Riviera adventure from Nice. Dive into Azure seas and experience breathtaking clifftop drives.</p>
            </Carousel.Caption>
            </Carousel.Item>
            <Carousel.Item>
            <img
            className="d-block w-100"
            style={{height : 500}}
            src="/images/3dest.jpeg"
            alt="Third slide"
            />

            <Carousel.Caption>
            <h3>Monterey, U.S.</h3>
            <p>Step into an enviable lifestyle. Surf or simply relax on deserted beaches, See the spectacular Monterey Bay Aquarium and pause for coffee at Palace Trattoria - the real Blue Blues Cafe.
            </p>
            </Carousel.Caption>
            </Carousel.Item>
            </Carousel>
        </div>
    )
}