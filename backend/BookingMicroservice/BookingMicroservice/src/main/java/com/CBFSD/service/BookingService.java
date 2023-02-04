package com.CBFSD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.CBFSD.entity.Booking;
import com.CBFSD.entity.CabType;
import com.CBFSD.exception.IdAlreadyExistsException;
import com.CBFSD.repository.BookingRepository;
import com.mysql.cj.exceptions.NumberOutOfRange;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public String storeBooking(Booking booking) throws IdAlreadyExistsException {
		Optional<Booking> result = bookingRepository.findById(booking.getBookingId());
		if(result.isPresent()) {
			throw new IdAlreadyExistsException();
		}else {
			CabType cabtype = restTemplate.getForObject("http://CAB-TYPE-MICRO-SERVICE/cabtype/findCabTypeById/"+booking.getCabTypeId(), CabType.class);
			System.out.println(cabtype.getCabTypeId()+" "+cabtype.getCabTypeName());
			booking.setCabTypeId(cabtype.getCabTypeId());
			Double fare = booking.getBookingDistance()*cabtype.getCabTypeFare()*1.0; 
			booking.setBookingFare(fare);
			bookingRepository.save(booking);
			return "Booking Details stored successfully";
		}
	}

	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}
	
	public Booking findBooking(int pid) {
		Optional<Booking> result = bookingRepository.findById(pid);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}
	
	public String deleteBooking(int pid) {
		Optional<Booking> result = bookingRepository.findById(pid);
		if(result.isPresent()) {
			Booking b = result.get();
			bookingRepository.delete(b);
			return "Booking details deleted successfully";
		}else {
			throw new IndexOutOfBoundsException("Booking with same Id exists");
		}
	}
	
	public String updateBooking(Booking newBooking) {
		Optional<Booking> result = bookingRepository.findById(newBooking.getBookingId());
		if(result.isPresent()) {
			Booking booking = result.get();
			booking.setBookingDate(newBooking.getBookingDate());
			booking.setBookingFare(newBooking.getBookingFare());
			booking.setBookingTime(newBooking.getBookingTime());
			booking.setBookingDistance(newBooking.getBookingDistance());
			bookingRepository.saveAndFlush(booking);
			return "Booking details updated successfully";
		}else {
			return "Booking not present";
		}
	}
	
	public String deleteAllBookings() {
		bookingRepository.deleteAll();
		return "All records deleted";
	}
}
