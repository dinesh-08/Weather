import React, { useState } from "react";

function Weather() {
  const [cityName, setCityName] = useState("");
  const [weatherInfo, setWeatherInfo] = useState("");

  const handleInputChange = (event) => {
    setCityName(event.target.value);
  };

  const fetchLastWeatherRecord = async () => {
    try {
      const response = await fetch(
        "http://localhost:8080/weather/getLastRecord"
      );
      if (response.ok) {
        const data = await response.json();
        return data;
      } else {
        return null;
      }
    } catch (error) {
      console.error("Error:", error);
      return null;
    }
  };

  const weatherDetails = async () => {
    try {
      const response = await fetch(
        `http://localhost:8080/weather/get/${cityName}`
      );
      if (response.ok) {
        const data = await response.json();
        console.log(data);
        setWeatherInfo(
          `Current Weather Report In ${cityName} : Temp:${parseInt(
            data.temp,
            10
          )} Temp_min: ${parseInt(data.temp_min, 10)} Temp_max: ${parseInt(
            data.temp_max,
            10
          )} Humdity: ${data.humidity} Pressure: ${data.pressure} Feels_like: ${
            data.feels_like
          }`
        );

        // Fetch the last record after getting weather details
        //   const lastRecord = await fetchLastWeatherRecord();
        //   if (lastRecord) {
        //     console.log("Last Record:", lastRecord); // You can handle the last record data here
        //   } else {
        //     console.log("Last record not available");
        //   }
      } else {
        setWeatherInfo("Weather details not available");
      }
    } catch (error) {
      console.error("Error:", error);
      setWeatherInfo("An error occurred");
    }
  };

  return (
    <div>
      <input
        type="text"
        placeholder="Enter city name..."
        value={cityName}
        onChange={handleInputChange}
      />
      <button onClick={weatherDetails}>Enter</button>
      <p>{weatherInfo}</p>
    </div>
  );
}

export default Weather;
