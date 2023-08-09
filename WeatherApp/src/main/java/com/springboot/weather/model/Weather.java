package com.springboot.weather.model;

import org.springframework.stereotype.Component;

@Component
public class Weather {
	
		private String cityName;
	    private String unit;
		public String getCityName() {
			return cityName;
		}
		public void setCityName(String cityName) {
			this.cityName = cityName;
		}
		public String getUnit() {
			return unit;
		}
		public void setUnit(String unit) {
			this.unit = unit;
		}
	    
}
