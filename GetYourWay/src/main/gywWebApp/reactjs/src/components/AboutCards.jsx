import React from 'react';
import AboutCard1 from './AboutCard1';

const cards = [
    {
        id: 1,
        title: 'Benji',
        image: './images/logo.png',
        description: 'Studied Computer Science & Maths at university',
        office: 'Working at the  office'
    },
    {
        id: 2,
        title: 'Charlotte',
        image: './images/Charlotte.jpg',
        description: 'Studied Psychology at university',
        office: 'Working at the  office'
    },
    {
        id: 3,
        title: 'Ryan',
        image: './images/Carousel3.jpg',
        description: 'Studied Computer Science at university',
        office: 'Working at the  office'
    },
    {
        id: 4,
        title: 'Sarah',
        image: './images/Sarah.jpg',
        description: 'Studied French & Italian and Political Communication at university',
        office: 'Working at the  office'
    },
    {
        id: 5,
        title: 'Trev',
        image: './images/Carousel2.jpg',
        description: 'Studied Computer Science at university',
        office: 'Working at the  office'
    },
]


function AboutCards() {
    return (
        <div className="container-sm d-flex justify-content-md-center align-items-center h-100">
            <div className="row">
                {
                    cards.map((card) => (
                        <div className="col-md-4" key={card.id}>
                            <AboutCard1 title={card.title} image={card.image}
                                        description={card.description} office={card.office}/>
                        </div>
                    ))
                }


            </div>
        </div>
    )
}

export default AboutCards;