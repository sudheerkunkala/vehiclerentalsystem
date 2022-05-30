package com.vehiclerentalsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.vehiclerentalsystem.entity.Booking;
import com.vehiclerentalsystem.repository.BookingRepository;

@SpringBootTest
public class BookingServiceTest {
	
	@InjectMocks
	private BookingService bookingService= new BookingServiceImpl();
	
	@Mock
	private BookingRepository bookingRepository;
	
	@Test
	public void testSaveBooking() {
		
		Booking booking = new Booking();
		booking.setBookingId(100);
		booking.setStartTime("2am");
		booking.setEndTime("7am");
		booking.setCarId(1234);
		booking.setUserId(4321);
		booking.setAmountPerHour(2000);
		
		when(bookingRepository.save(booking)).thenReturn(booking);
		
		Booking newbooking=bookingService.saveBooking(booking);
		
		assertEquals("2am",newbooking.getStartTime());
		
		verify(bookingRepository,times(1)).save(booking);
	}
	
	@Test
	public void deleteBooking() {
		Booking booking = new Booking();
		booking.setBookingId(100);
		booking.setStartTime("2am");
		booking.setEndTime("7am");
		booking.setCarId(1234);
		booking.setUserId(4321);
		booking.setAmountPerHour(2000);
		
		Optional<Booking> optionalBooking= Optional.of(booking);
		
		when(bookingRepository.findById(100)).thenReturn(optionalBooking);
		
		bookingService.deleteBooking(100);
		
		verify(bookingRepository,times(1)).findById(100);
		verify(bookingRepository,times(1)).deleteById(100);
	}
	public void updateBooking() {
		
		Booking booking = new Booking();
		booking.setBookingId(101);
		booking.setStartTime("2am");
		booking.setEndTime("7am");
		booking.setCarId(1234);
		booking.setUserId(4321);
		booking.setAmountPerHour(2000);
		
		Optional<Booking> optionalBooking= Optional.of(booking);
		
		when(bookingRepository.findById(100)).thenReturn(optionalBooking);
		
		Booking newbooking=bookingService.saveBooking(booking);
		assertEquals("4am",newbooking.getStartTime());
		
		bookingService.updateBooking(booking);
		
		verify(bookingRepository,times(1)).save(booking);
		verify(bookingRepository,times(1)).findById(100);
	}

}
