package com.springboot.weather.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WeatherDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	private double temp;
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	private double temp_max;
	
	private double temp_min;
	private double pressure;
	private int humidity;
	
	private int feels_like;
	
	
public double getTemp_max() {
return temp_max;
}
public void setTemp_max(double d) {
this.temp_max = d;
}
public double getTemp_min() {
return temp_min;
}
public void setTemp_min(double temp_min) {
this.temp_min = temp_min;
}
public double getPressure() {
return pressure;
}
public void  setPressure(double  pressure) {
this.pressure = pressure;
}
public int getHumidity() {
return humidity;
}
public void setHumidity(int humidity) {
this.humidity = humidity;
}


public int getFeels_like() {
return feels_like;
}
public void setFeels_like(int feels_like) {
this.feels_like = feels_like;
}

}