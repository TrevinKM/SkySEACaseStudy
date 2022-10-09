import React from 'react';

const Header = () => {
    return (
        <header style={{paddingTop: '15px', paddingBottom: '15px', color: 'SlateGray'}}>
            <h3 style={{color : 'DarkSlateGray'}}>Start your adventure here...</h3>
            <p>Be inspired and browse through our
                <a id="rd" href="/recommendedDestinations" ><strong style={{color : 'DarkSlateGray'}}> recommended destinations</strong> </a>
                from Sky shows you love!
            </p>
        </header>
    );
};

export default Header;