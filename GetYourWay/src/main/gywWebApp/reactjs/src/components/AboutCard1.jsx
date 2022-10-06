import React from 'react';
import PropTypes from 'prop-types';

function AboutCard1 ({title, image, description, office}) {
    return (
        <>
            <div className="card text-center justify-content-md-center bg-dark">
                <img src={image} alt="image of the Increment" width="100%" />
                <div className="card-body">
                    <h4 className="card-title text-secondary">{title}</h4>
                    <p className="card-text text-secondary">{description}</p>
                    <p className="card-text text-secondary">{office}</p>
                </div>
            </div>
        </>
    );
}

AboutCard1.propTypes = {
    title: PropTypes.string.isRequired,
    image: PropTypes.string.isRequired,
    description: PropTypes.string.isRequired,
    office: PropTypes.string.isRequired
}


export default AboutCard1;