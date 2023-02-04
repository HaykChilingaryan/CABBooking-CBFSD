package com.CBFSD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CBFSD.entity.Booking;
import com.CBFSD.exception.IdAlreadyExistsException;
import com.CBFSD.service.BookingService;

@RestController
@RequestMapping("booking")
@CrossOrigin
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	@PostMapping(value = "storeBooking",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeProduct(@RequestBody Booking booking) throws IdAlreadyExistsException {
		return bookingService.storeBooking(booking);
	}
	
	@GetMapping(value = "findAllBookings",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Booking> findAllProduct() {
		return bookingService.getAllBookings();
	}
	
	@GetMapping(value="findBookingById/{bookingId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Booking findProductById(@PathVariable("bookingId") int bookingId) {
		return bookingService.findBooking(bookingId);
	}
	
	@PutMapping(value = "updateBooking",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateProduct(@RequestBody Booking booking) {
		return bookingService.updateBooking(booking);
	}
	
	@DeleteMapping(value="deleteBookingById/{bookingId}")
	public String deleteProductById(@PathVariable("bookingId") int bookingId) {
		return bookingService.deleteBooking(bookingId);
	}
	
	@DeleteMapping(value="deleteAll")
	public String deleteAll() {
		return bookingService.deleteAllBookings();
	}
}
