package com.springboot.weather.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.weather.model.WeatherDetails;
import com.springboot.weather.repository.WeatherDetailsRepository;

@Service
public class WeatherDetailsService {
	
	@Autowired
	private WeatherDetailsRepository wdp;

	public WeatherDetails insert(WeatherDetails wd) {
		
		return wdp.save(wd);
		
	}
	 public WeatherDetails getLastRecord() {
	        
	        
	        
	         List<WeatherDetails> allWeatherDetails = wdp.findAll();
	         if (!allWeatherDetails.isEmpty()) {
	             return allWeatherDetails.get(allWeatherDetails.size() - 1);
	         } else {
	             return null; 
	         } 
	    }


    }
