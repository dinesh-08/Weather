package com.springboot.weather.controller;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.weather.model.Weather;
import com.springboot.weather.model.WeatherDetails;
import com.springboot.weather.service.WeatherDetailsService;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@RestController
public class WeatherController {
    private OkHttpClient client;
    private Response response;
    
    @Autowired
    private Weather weather;
    
    @Autowired
    private WeatherDetailsService wds;
    
    
    private String APIkey = "ba61e79a0119a86f77cc471643451b24";
    
    private String s;
    
    
    @GetMapping("/weather/get/{city}")
    public WeatherDetails getWeatherDetails(@PathVariable("city") String city) {
    	System.out.println(city);
    	s = city;
    	WeatherDetails wd = new WeatherDetails();
    	double k= 273.15;
    	System.out.println(getWeather().getJSONObject("main"));
    	wd.setTemp(getWeather().getJSONObject("main").getDouble("temp")-k);
    	wd.setTemp_max(getWeather().getJSONObject("main").getDouble("temp_max")-k);
    	wd.setTemp_min(getWeather().getJSONObject("main").getDouble("temp_min")-k);
    	wd.setHumidity(getWeather().getJSONObject("main").getInt("humidity"));
    	wd.setPressure(getWeather().getJSONObject("main").getInt("pressure"));
    	wd.setFeels_like(getWeather().getJSONObject("main").getInt("feels_like")-(int)k);
    
    	wd = wds.insert(wd);

    	return wd;
    }

    public JSONObject getWeather(){
        client = new OkHttpClient();  
        Request request = new Request.Builder()
                .url("http://api.openweathermap.org/data/2.5/weather?q="+s+"&units="+"C"+"&appid="+APIkey)
                .build();

        try {
            response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        }catch (IOException | JSONException e){
            e.printStackTrace();
        }
        return null;
    }
   
}
