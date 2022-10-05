import React, { useState } from "react";
import TextInput from './TextInput';
import LocationSelect from './LocationSelect'
import axios from "axios";

function Locate(props) {

    const [value, setValue] = useState('');
    const [locations, setLocations] = useState([]);


    const submit = (e) => {
        e.preventDefault();
        axios.get("http://localhost:8082/api/airportlocations", {params: {keyword: "LON"}})
            .then((response) => console.log(response.data))

        // fetch(
        //     "/api/airportlocations?keyword=" + value
        // )
        //     .then((response) => response.json())
        //     .then((json) => {
        //         setLocations(json);
        //     });
    }
    return (
        <div>
            <TextInput onSubmit={submit} display={props.display} onChange={(e) => setValue(e.target.value)} value={value} />
            <LocationSelect data={locations} handleChoice={props.handleChoice} />
        </div>
    );
};
export default Locate;