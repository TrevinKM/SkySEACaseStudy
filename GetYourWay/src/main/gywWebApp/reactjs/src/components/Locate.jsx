import React, {useState} from "react";
import TextInput from './TextInput';
import LocationSelect from './LocationSelect'
import axios from "axios";
import {ClipLoader} from "react-spinners";

function Locate(props) {

    const [value, setValue] = useState('');
    const [locations, setLocations] = useState([]);
    const [loading, setLoading] = useState(false);
    const override = {
        display: "block",
        margin: "0 auto",
    };
    const submit = async (e) => {
        e.preventDefault();
        if (props.value){setValue(props.value)}
        setLoading(true);
        await axios.get('http://localhost:8082/api/airportlocations', {params: {keyword:(props.value ? props.value: value) }})
            .then((res) => {
                setLocations(res.data);
                setLoading(false);
            })
            .catch(() => setLoading(false));
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
            {loading ?
                <ClipLoader
                    color={'#34e1eb'}
                    loading={loading}
                    size={50}
                    cssOverride={override}
                    aria-label="Loading Spinner"
                    data-testid="loader"
                />
                :
                <p>
                    <LocationSelect data={locations} handleChoice={props.handleChoice}/>
                </p>
            }

        </div>
    );
}
export default Locate;