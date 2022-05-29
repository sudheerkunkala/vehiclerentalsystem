package com.vehiclerentalsystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="car_tbl")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="car_id")
	private int carId;
	
	@Column(name="car_number")
	private String carNumber;
	
	@Column(name="car_model")
	private String carModel;
	
	@Column(name="car_seatingcapacity")
	private int seatCapacity;
	
	@Column(name="price_per_hour")
	private String pricePerHour;
	
	@Column(name="fuel_type")
	private String fuelType;
	
	
	@ManyToOne
	//@JoinColumn(name="car_id")
	private User user;
	
	@OneToOne(mappedBy="car",cascade=CascadeType.ALL)
	private Booking booking;

	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	public String getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(String pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	
	
}
