import React from 'react';

const WeatherDay = (props) => {
    return (
                            <>
                                <tr>
                                    <td>
                                        Temperature (°F) <br />
                                        {props.temp}
                                    </td>
                                    <td>
                                        Humidity (%)<br />
                                        {props.humidity}
                                    </td>
                                    <td>
                                        Precipitation (in)<br/>
                                        {props.precip}
                                    </td>
                                </tr>
                            </>
    )
}

export default WeatherDay;


