package com.springboot.weather.service;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.weather.controller.WeatherController;


@Service
public class WeatherService {

	@Autowired
	private WeatherController weatherController;
	public JSONArray returnWeatherArray() throws JSONException {
        JSONArray weatherJsonArray = weatherController.getWeather().getJSONArray("weather");
        return weatherJsonArray;
    }

    public JSONObject returnMainObject() throws JSONException {
    	
        JSONObject mainObject = weatherController.getWeather().getJSONObject("main");
      
        return mainObject;
    }


    public JSONObject returnWindObject() throws JSONException {
        JSONObject wind = weatherController.getWeather().getJSONObject("wind");
        return wind;
        }

    public JSONObject returnSysObject() throws JSONException{
        JSONObject sys = weatherController.getWeather().getJSONObject("sys");
        return sys;
        } 

}
