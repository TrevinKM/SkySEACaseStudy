import React, {useState} from "react";
import TextInput from './TextInput';
import { useNavigate } from "react-router-dom";

function SearchBar(props) {
    const navigate = useNavigate();
    const [value, setValue] = useState('');

    const submit = (e) => {
        e.preventDefault();
        navigate('/travelInfo',{state: {destination: value}})
    }

    return (
        <div>
            <p>
                <TextInput onSubmit={submit} display={props.display} onChange={(x) => setValue(x.target.value)} value={value} />
            </p>
        </div>
    );
};
export default SearchBar;