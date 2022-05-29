package com.vehiclerentalsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehiclerentalsystem.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
	
	 List<Car> findByCarModel(String carModel);
		
		
	 List<Car> findBySeatCapacity(int seatCapacity);

	
	 List<Car> findByFuelType(String fuelType);
	
	 
}

