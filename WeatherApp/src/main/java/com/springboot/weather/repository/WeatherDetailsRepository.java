package com.springboot.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.weather.model.WeatherDetails;

public interface WeatherDetailsRepository extends JpaRepository<WeatherDetails, Integer> {

}
