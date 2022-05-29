package com.vehiclerentalsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vehiclerentalsystem.entity.Booking;
import com.vehiclerentalsystem.exception.BookingNotFoundException;
import com.vehiclerentalsystem.repository.BookingRepository;

@Service
public  class BookingServiceImpl implements BookingService{


	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public Booking saveBooking(Booking booking) {
			
			Booking savedBooking = bookingRepository.save(booking);
			return savedBooking;
	}

	@Override
	public Booking updateBooking(Booking booking) {
		
        Optional<Booking> optionalBooking =  bookingRepository.findById(booking.getBookingId());
		
		if(optionalBooking.isEmpty()) {
			throw new BookingNotFoundException("Booking Not found with id: "+booking.getBookingId());
		}
		Booking updatedBooking = bookingRepository.save(booking);
		
		return updatedBooking;
	}

	@Override
	public void deleteBooking(int bookingId) {
		Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
		if(optionalBooking.isEmpty()) {
			throw new BookingNotFoundException("Booking Not found with id: "+bookingId);
		}
		
		bookingRepository.deleteById(bookingId);		
	}
}
