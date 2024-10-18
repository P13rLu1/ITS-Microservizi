package it.its.formazione.springbootesercizio2pierluigibuttazzo.service;

import it.its.formazione.springbootesercizio2pierluigibuttazzo.server.model.BookingDTO;

import java.util.List;

public interface BookingService {

    BookingDTO createBooking(BookingDTO bookingDTO);

    void deleteBooking(Integer id);

    List<BookingDTO> getAllBookings();

    BookingDTO getBookingById(Integer id);

    BookingDTO updateBooking(Integer id, BookingDTO bookingDTO);
}
