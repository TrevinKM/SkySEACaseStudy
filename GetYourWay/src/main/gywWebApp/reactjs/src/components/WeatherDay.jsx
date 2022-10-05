import React from 'react';

const WeatherDay = (props) => {
    return (
                            <>
                                <tr>
                                    <td>
                                        Temperature (°C) <br />
                                        {props.temp}
                                    </td>
                                    <td>
                                        Humidity (%)<br />
                                        {props.humidity}
                                    </td>
                                    <td>
                                        Precipitation (mm)<br/>
                                        {props.precip}
                                    </td>
                                </tr>
                            </>
    )
}

export default WeatherDay;


