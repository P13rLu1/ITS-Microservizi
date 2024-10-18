package it.its.formazione.springbootesercizio2pierluigibuttazzo.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.its.formazione.springbootesercizio2pierluigibuttazzo.server.api.BookingsApi;
import it.its.formazione.springbootesercizio2pierluigibuttazzo.server.model.BookingDTO;
import it.its.formazione.springbootesercizio2pierluigibuttazzo.service.BookingService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController implements BookingsApi {

    Logger logger = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    private BookingService bookingService;

    @Override
    public ResponseEntity<BookingDTO> createBooking(@Parameter(name = "BookingDTO", required = true) @Valid @RequestBody BookingDTO bookingDTO) {
        BookingDTO booking = bookingService.createBooking(bookingDTO);

        logger.info("Booking creato con successo");

        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteBooking(@Parameter(name = "id", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id) {
        bookingService.deleteBooking(id);

        logger.info("Booking eliminato con successo");

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        List<BookingDTO> bookings = bookingService.getAllBookings();

        logger.info("Lista bookings recuperata con successo");

        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BookingDTO> getBookingById(@Parameter(name = "id", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id) {
        BookingDTO booking = bookingService.getBookingById(id);

        logger.info("Booking recuperato con successo");

        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BookingDTO> updateBooking(@Parameter(name = "id", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id, @Parameter(name = "BookingDTO", required = true) @Valid @RequestBody BookingDTO bookingDTO) {
        BookingDTO booking = bookingService.updateBooking(id, bookingDTO);

        logger.info("Booking modificato con successo");

        return new ResponseEntity<>(booking, HttpStatus.OK);
    }
}
