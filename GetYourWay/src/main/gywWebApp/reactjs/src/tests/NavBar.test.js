import React from "react";
import { create } from 'react-test-renderer';

import NavBar from "../Components/NavBar";

test(`NavBar matches snapshot`, () => {
    const header = create(<NavBar />);
    expect(header.toJSON()).toMatchSnapshot();
})