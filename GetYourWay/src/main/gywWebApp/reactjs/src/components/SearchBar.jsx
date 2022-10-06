import React, {useEffect, useState} from "react";
import TextInput from './TextInput';
import LocationSelect from './LocationSelect'
import axios from "axios";
import TravelInfo from "./TravelInfo";
import {useNavigate} from "react-router-dom";



function SearchBar() {

    const [search, setSearch] = useState('');

    const submit = (e) => {
        e.preventDefault();
    };
    return (
        <div>
            <p>Where do you want to go?</p>
            <form onSubmit={submit}>
                <input
                    type="text"
                    name="Search"
                    placeholder={"City"}
                    value={search}
                    onChange={(e) => setSearch(e.target.value)}
                />
                <input type="submit" value="Submit" />
            </form>
        </div>
    );
};
export default SearchBar;