package com.vehiclerentalsystem.service;


import com.vehiclerentalsystem.entity.Booking;

public interface BookingService {
	
	
    public Booking updateBooking(Booking booking);
	
	public void deleteBooking(int bookingId);

	public Booking saveBooking(Booking booking);


}
