package com.travelbnb.service;

import com.travelbnb.payload.BookingDto;

import java.util.List;

public interface BookingService {

    BookingDto createBooking(BookingDto bookingDto);
    BookingDto getBookingById(Long id);
    List<BookingDto> getAllBookings();
    void deleteBooking(Long id);
}
