import React, {useEffect, useState} from "react";
import TextInput from './TextInput';
import LocationSelect from './LocationSelect'
import axios from "axios";

function Locate(props) {

    const [value, setValue] = useState('');
    const [locations, setLocations] = useState([]);

    const submit = async (e) => {
        e.preventDefault();
        if (props.value){setValue(props.value)}
        await axios.get('http://localhost:8082/api/airportlocations', {params: {keyword:(props.value ? props.value: value) }})
            .then((res) => {setLocations(res.data);

            console.log(value);
            console.log(props.value)});
    }

    return (
        <div>
            <p>
            <TextInput onSubmit={submit} display={props.display}
                       onChange={(x) => setValue(x.target.value)}
                       value={(props.value ? props.value: value)}   />
            </p>
            {/*
            value={props.value ? props.value : value}
            */}
            <p>
            <LocationSelect data={locations} handleChoice={props.handleChoice} />
            </p>
        </div>
    );
};
export default Locate;