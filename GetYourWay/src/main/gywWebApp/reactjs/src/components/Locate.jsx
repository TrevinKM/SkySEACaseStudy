import React, {useEffect, useState} from "react";
import TextInput from './TextInput';
import LocationSelect from './LocationSelect'
import axios from "axios";

function Locate(props) {

    const [value, setValue] = useState('');
    const [locations, setLocations] = useState([]);

    // useEffect((e) => {
    //     const submit = () => {
    //         e.preventDefault();
    //         axios.get("http://localhost:8082/api/airportlocations", {params: {keyword: "LON"}})
    //             .then((response) => response)
    //             .then((json) => {
    //                 setLocations(json);
    //             });
    //         submit();
    // }, []);
    //
    // useEffect((e) => {
    //
    //     submit();
    // }, []);
    const submit = async (e) => {
        e.preventDefault();
        await axios.get('http://localhost:8082/api/airportlocations', {params: {keyword: value}})
            .then((res) => setLocations(res.data));
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
            <TextInput onSubmit={submit} display={props.display} onChange={(x) => setValue(x.target.value)} value={value} />
            <LocationSelect data={locations} handleChoice={props.handleChoice} />
        </div>
    );
};
export default Locate;