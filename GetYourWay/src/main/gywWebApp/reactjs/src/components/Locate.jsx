import React, {useEffect, useState} from "react";
import TextInput from './TextInput';
import LocationSelect from './LocationSelect'
import axios from "axios";

function Locate(props) {

    const [value, setValue] = useState('');
    const [locations, setLocations] = useState([]);

    const submit = async (e) => {
        e.preventDefault();
        await axios.get('http://18.169.58.161:8082/api/airportlocations', {params: {keyword: value}})
            .then((res) => {setLocations(res.data);
            console.log(res.data)});
    }
    // const submit = (e) => {
    //     e.preventDefault();
    //     fetch(
    //         "/api/airportlocations?keyword=" + value
    //     )
    //         .then((response) => response.json())
    //         .then((json) => {
    //             setLocations(json);
    //         });
    // }




    return (
        <div>
            <p>
            <TextInput onSubmit={submit} display={props.display} onChange={(x) => setValue(x.target.value)} value={value} />
            </p>
            <p>
            <LocationSelect data={locations} handleChoice={props.handleChoice} />
            </p>
        </div>
    );
};
export default Locate;