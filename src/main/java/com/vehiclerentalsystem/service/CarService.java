package com.vehiclerentalsystem.service;

import java.util.List;

import com.vehiclerentalsystem.entity.Car;

public interface CarService { 
	public List<Car> getCarsByCarModel(String carModel);
	  
	public List<Car> getCarsBySeatCapacity(int seatCapacity);
	
	public List<Car> getCarsByFuelType(String fuelType);

	

}
