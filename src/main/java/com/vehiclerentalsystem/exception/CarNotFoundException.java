package com.vehiclerentalsystem.exception;

public class CarNotFoundException extends RuntimeException{
	public CarNotFoundException(String msg) {
		super(msg);
	}

}
