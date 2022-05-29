package com.vehiclerentalsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiclerentalsystem.entity.Car;
import com.vehiclerentalsystem.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepository;

	@Override
	public List<Car> getCarsByCarModel(String carModel) {
		List<Car> cars = carRepository.findByCarModel(carModel);
		return cars;
	}

	@Override
	public List<Car> getCarsBySeatCapacity(int seatCapacity) {
		List<Car> cars = carRepository.findBySeatCapacity(seatCapacity);
		return cars;
	}

	@Override
	public List<Car> getCarsByFuelType(String fuelType) {
		List<Car> fueltypes = carRepository.findByFuelType(fuelType);
		return fueltypes;
	}
}
