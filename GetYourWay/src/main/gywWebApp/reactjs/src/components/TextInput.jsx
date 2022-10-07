import React from "react";
import Button from "react-bootstrap/Button";

const TextInput = props => (
    <form onSubmit={props.onSubmit}>
        <label>{props.display} </label>
        <input value={props.value} onChange={props.onChange}></input>
        <Button type="submit" className="btn-lg" value="Enter"></Button>
    </form>
);

export default TextInput;