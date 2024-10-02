package com.travelbnb.service;

import com.travelbnb.entity.Booking;
import com.travelbnb.payload.BookingDto;
import com.travelbnb.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public BookingDto createBooking(BookingDto bookingDto) {
        Booking booking = new Booking();
        // map BookingDto to Booking entity (add all required fields)
        booking = bookingRepository.save(booking);
        return mapToDto(booking);
    }

    @Override
    public BookingDto getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        return mapToDto(booking);
    }

    @Override
    public List<BookingDto> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    private BookingDto mapToDto(Booking booking) {
        BookingDto dto = new BookingDto();
        // map Booking entity to BookingDto
        return dto;
    }
}
