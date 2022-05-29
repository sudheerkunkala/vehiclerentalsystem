package com.vehiclerentalsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vehiclerentalsystem.entity.Car;
import com.vehiclerentalsystem.service.CarService;
@RestController
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@GetMapping("/car/bymodel/{modelName}")
	public List<Car> fetchCarsByModel(@PathVariable("modelName") String carModel) {
			
		List<Car> cars = carService.getCarsByCarModel(carModel);
						
		return cars;
	}
	
	@GetMapping("/car/byfueltype/{fuelTypeName}")
	public List<Car> fetchCarsByCarFuelType(@PathVariable("fueltypeName") String fuelType) {
			
		List<Car> cars = carService.getCarsByFuelType(fuelType);
						
		return cars;
	}
	
	@GetMapping("/car/bycapacity/{capacitySize}")
	public List<Car> fetchCarsBySeatCapacity(@PathVariable("capacitySize") int seatCapacity) {
			
		List<Car> cars = carService.getCarsBySeatCapacity(seatCapacity);
						
		return cars;
	}

}
